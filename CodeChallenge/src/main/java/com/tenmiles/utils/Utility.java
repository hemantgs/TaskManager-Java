package com.tenmiles.utils;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import com.tenmiles.dto.Task;
import com.tenmiles.dto.TaskDuration;
import com.tenmiles.model.TaskDurEO;
import com.tenmiles.model.TaskEO;

public class Utility {
    public static Set<TaskDuration> gettaskDurObj(Set<TaskDurEO> durationSet) {
        Set<TaskDuration> set = new HashSet<TaskDuration>();
        for (TaskDurEO dur : durationSet) {
            long hh = TimeUnit.MILLISECONDS.toHours(dur.getDuration());
            long mm = TimeUnit.MILLISECONDS.toMinutes(dur.getDuration())
                    - TimeUnit.HOURS.toMinutes(hh);
            TaskDuration local = new TaskDuration();
            local.setDuration(dur.getDuration());
            local.setTimeGap(String.valueOf(hh) + ":" + String.valueOf(mm));
            local.setStartTimestamp(dur.getStarteTimestamp());
            local.setEndTimestamp(dur.getEndTimestamp());
            set.add(local);
        }
        return set;
    }

    public static List<Task> getTaskListModel(List<TaskEO> taskEoList) {
        List<Task> task = new ArrayList<Task>();
        for (TaskEO eo : taskEoList) {
            Task temp = new Task();
            temp.setTaskId(eo.getTaskId());
            temp.setGrpId(eo.getGrpId());
            temp.setTaskName(eo.getTaskName());
            eo.getTaskDurations().size();
            temp.setTaskDurationSet(Utility.gettaskDurObj(eo.getTaskDurations()));
            temp.setStatus(eo.getStatus());
            task.add(temp);
        }
        return task;
    }

    public static TaskDuration getTaskDurObj(TaskDuration taskDurRequest) {
        TaskDuration taskDurToBeSaved = new TaskDuration();
        SimpleDateFormat f = new SimpleDateFormat("HH:mm");
        Date d1 = new Date();
        Date d2 = new Date();
        try {
            d1 = f.parse(taskDurRequest.getStartTimeString());
            taskDurToBeSaved.setStartTimestamp(d1.getTime());
            d2 = f.parse(taskDurRequest.getEndTimeString());
            taskDurToBeSaved.setEndTimestamp(d2.getTime());
            long diff = d2.getTime() - d1.getTime();
            taskDurToBeSaved.setDuration(diff);
            taskDurToBeSaved.setCurrDate(Calendar.getInstance().getTime());
            taskDurToBeSaved.setTaskId(taskDurRequest.getTaskId());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return taskDurToBeSaved;
    }

    public static Task buildTaskDetailObj(TaskEO taskEo) {
        Task task = new Task();
        task.setTaskId(taskEo.getTaskId());
        task.setGrpId(taskEo.getGrpId());
        task.setTaskName(taskEo.getTaskName());
        taskEo.getTaskDurations().size();
        task.setTaskDurationSet(Utility.gettaskDurObj(taskEo.getTaskDurations()));
        return task;
    }

    public static List<String> buildDashBoardData(List<BigDecimal> dashData) {
        List<String> result = new ArrayList<String>();
        for (BigDecimal data : dashData) {
            long hh = TimeUnit.MILLISECONDS.toHours(data.longValue());
            long mm = TimeUnit.MILLISECONDS.toMinutes(data.longValue())
                    - TimeUnit.HOURS.toMinutes(hh);
            result.add(String.valueOf(hh) + "." + String.valueOf(mm));
        }
        return result;
    }
}
