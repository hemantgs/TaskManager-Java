package com.tenmiles.controller;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tenmiles.dao.ITaskDao;
import com.tenmiles.dto.Task;
import com.tenmiles.dto.TaskDuration;
import com.tenmiles.dto.TaskResponse;
import com.tenmiles.model.TaskEO;
import com.tenmiles.utils.Utility;

@RestController
public class TaskController {
    @Autowired
    ITaskDao taskdao;

    @RequestMapping(value = "/getTaskList", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TaskResponse> getTaskList() {
        List<TaskEO> list = taskdao.getTaskList();
        List<Task> task = new ArrayList<Task>();
        for (TaskEO eo : list) {
            Task temp = new Task();
            temp.setTaskId(eo.getTaskId());
            temp.setGrpId(eo.getGrpId());
            temp.setTaskName(eo.getTaskName());
            eo.getTaskDurations().size();
            temp.setTaskDurationSet(Utility.gettaskDurObj(eo.getTaskDurations()));
            temp.setStatus(eo.getStatus());
            task.add(temp);
        }
        TaskResponse response = new TaskResponse();
        response.setTaskList(task);
        return new ResponseEntity<TaskResponse>(response, HttpStatus.OK);
    }

    @RequestMapping(value = "/addTask", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String addTask(RequestEntity<Task> taskToAdd) {
        taskdao.addtask(taskToAdd.getBody());

        return "Success";
    }

    @RequestMapping(value = "/addTaskDuration", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String addTaskDur(RequestEntity<TaskDuration> taskDurToAdd) {
        TaskDuration req = taskDurToAdd.getBody();
        SimpleDateFormat f = new SimpleDateFormat("HH:mm");
        Date d1 = new Date();
        Date d2 = new Date();
        try {
            d1 = f.parse(req.getStartTimeString());
            req.setStartTimestamp(d1.getTime());
            d2 = f.parse(req.getEndTimeString());
            req.setEndTimestamp(d2.getTime());
            long diff = d2.getTime() - d1.getTime();
            req.setDuration(diff);
            req.setCurrDate(Calendar.getInstance().getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        taskdao.addtaskDur(req);
        return "Success";
    }

    @RequestMapping(value = "/deleteTask", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String deleteTask(@RequestBody Task task) {

        taskdao.deleteTask(task.getTaskId());
        return "Success";
    }

    @RequestMapping(value = "/getTaskDetails", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Task getTaskDetails(@RequestBody Task task) {

        TaskEO eo = taskdao.getTaskDetails(task.getTaskId());
        Task temp = new Task();
        temp.setTaskId(eo.getTaskId());
        temp.setGrpId(eo.getGrpId());
        temp.setTaskName(eo.getTaskName());
        eo.getTaskDurations().size();
        temp.setTaskDurationSet(Utility.gettaskDurObj(eo.getTaskDurations()));
        return temp;
    }

    @RequestMapping(value = "/toggleStatus", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String toggleStatus(@RequestBody Task task) {

        taskdao.toggleStatus(task);
        return "Success";
    }

    @RequestMapping(value = "/getDashBoardData", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<String> getDashBoardData(@RequestBody Task task) {

        List<BigDecimal> dashData = taskdao.getDashBoardData(task);
        List<String> result = new ArrayList<String>();
        for (BigDecimal data : dashData) {
            long hh = TimeUnit.MILLISECONDS.toHours(data.longValue());
            long mm = TimeUnit.MILLISECONDS.toMinutes(data.longValue()) - TimeUnit.HOURS.toMinutes(hh);
            result.add(String.valueOf(hh) + ":" + String.valueOf(mm));
        }
        return result;
    }

}
