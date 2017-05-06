package com.tenmiles.business;

import java.util.List;

import com.tenmiles.dto.Task;
import com.tenmiles.dto.TaskDuration;
import com.tenmiles.model.TaskEO;

public interface ITaskBusiness {
    public List<Task> getTaskList();

    public void addtask(Task task);

    public void addtaskDur(TaskDuration taskDur);

    public void deleteTask(int taskId);

    public Task getTaskDetails(int taskId);

    public void toggleStatus(Task task);

    public List<String> getDashBoardData(Task task);
}
