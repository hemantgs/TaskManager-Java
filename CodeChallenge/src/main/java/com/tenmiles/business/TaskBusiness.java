package com.tenmiles.business;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tenmiles.dao.ITaskDao;
import com.tenmiles.dto.Task;
import com.tenmiles.dto.TaskDuration;
import com.tenmiles.model.TaskEO;
import com.tenmiles.utils.Utility;

@Service
public class TaskBusiness implements ITaskBusiness {

    @Autowired
    ITaskDao taskDao;

    public List<Task> getTaskList() {
        List<TaskEO> taskEoList = taskDao.getTaskList();
        return Utility.getTaskListModel(taskEoList);

    }

    public void addtask(Task task) {
        taskDao.addtask(task);

    }

    public void addtaskDur(TaskDuration taskDur) {
        TaskDuration durToBeSaved = Utility.getTaskDurObj(taskDur);
        taskDao.addtaskDur(durToBeSaved);

    }

    public void deleteTask(int taskId) {
        taskDao.deleteTask(taskId);

    }

    public Task getTaskDetails(int taskId) {
        TaskEO taskEo = taskDao.getTaskDetails(taskId);
        return Utility.buildTaskDetailObj(taskEo);
    }

    public void toggleStatus(Task task) {
        taskDao.toggleStatus(task);

    }

    public List<String> getDashBoardData(Task task) {
        List<BigDecimal> dashBoardData = taskDao.getDashBoardData(task);
        return Utility.buildDashBoardData(dashBoardData);
    }
}
