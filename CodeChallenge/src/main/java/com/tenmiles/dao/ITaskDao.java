package com.tenmiles.dao;

import java.math.BigDecimal;
import java.util.List;

import com.tenmiles.dto.Task;
import com.tenmiles.dto.TaskDuration;
import com.tenmiles.model.TaskEO;

public interface ITaskDao {

    public List<TaskEO> getTaskList();

    public void addtask(Task task);
    
    public void addtaskDur(TaskDuration taskDur);

    public void deleteTask(int i);

    public TaskEO getTaskDetails(int taskId);

    public void toggleStatus(Task task);

    public List<BigDecimal> getDashBoardData(Task task);
}
