package com.tenmiles.dto;

import java.util.List;

public class TaskResponse {
    private List<Task> taskList;

    /**
     * @return the taskList
     */
    public List<Task> getTaskList() {
        return taskList;
    }

    /**
     * @param taskList
     *            the taskList to set
     */
    public void setTaskList(List<Task> taskList) {
        this.taskList = taskList;
    }

}
