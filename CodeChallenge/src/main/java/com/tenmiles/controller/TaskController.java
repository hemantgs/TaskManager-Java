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

import com.tenmiles.business.ITaskBusiness;
import com.tenmiles.dao.ITaskDao;
import com.tenmiles.dto.Task;
import com.tenmiles.dto.TaskDuration;
import com.tenmiles.dto.TaskResponse;
import com.tenmiles.model.TaskEO;
import com.tenmiles.utils.Utility;

@RestController
public class TaskController {

    @Autowired
    ITaskBusiness taskBusiness;

    @RequestMapping(value = "/getTaskList", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TaskResponse> getTaskList() {
        List<Task> task = taskBusiness.getTaskList();
        TaskResponse response = new TaskResponse();
        response.setTaskList(task);
        return new ResponseEntity<TaskResponse>(response, HttpStatus.OK);
    }

    @RequestMapping(value = "/addTask", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String addTask(RequestEntity<Task> taskToAdd) {
        taskBusiness.addtask(taskToAdd.getBody());
        return "Success";
    }

    @RequestMapping(value = "/addTaskDuration", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String addTaskDur(RequestEntity<TaskDuration> taskDurToAdd) {
        taskBusiness.addtaskDur(taskDurToAdd.getBody());
        return "Success";
    }

    @RequestMapping(value = "/deleteTask", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String deleteTask(@RequestBody Task task) {

        taskBusiness.deleteTask(task.getTaskId());
        return "Success";
    }

    @RequestMapping(value = "/getTaskDetails", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Task getTaskDetails(@RequestBody Task task) {
        return taskBusiness.getTaskDetails(task.getTaskId());
    }

    @RequestMapping(value = "/toggleStatus", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String toggleStatus(@RequestBody Task task) {

        taskBusiness.toggleStatus(task);
        return "Success";
    }

    @RequestMapping(value = "/getDashBoardData", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<String> getDashBoardData(@RequestBody Task task) {
        List<String> result = taskBusiness.getDashBoardData(task);
        return result;
    }

}
