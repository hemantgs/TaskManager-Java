package com.tenmiles.dto;

import java.sql.Timestamp;
import java.util.Set;

public class Task {
    private int taskId;
    private String taskName;
    private int grpId;
    private Timestamp createTimestamp;
    private Timestamp updTimestamp;
    private Set<TaskDuration> taskDurationSet;
    private int status;

    /**
     * @return the taskId
     */
    public int getTaskId() {
        return taskId;
    }

    /**
     * @return the taskDurationSet
     */
    public Set<TaskDuration> getTaskDurationSet() {
        return taskDurationSet;
    }

    /**
     * @param taskDurationSet
     *            the taskDurationSet to set
     */
    public void setTaskDurationSet(Set<TaskDuration> taskDurationSet) {
        this.taskDurationSet = taskDurationSet;
    }

    /**
     * @param taskId
     *            the taskId to set
     */
    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    /**
     * @return the taskName
     */
    public String getTaskName() {
        return taskName;
    }

    /**
     * @param taskName
     *            the taskName to set
     */
    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    /**
     * @return the grpId
     */
    public int getGrpId() {
        return grpId;
    }

    /**
     * @param grpId
     *            the grpId to set
     */
    public void setGrpId(int grpId) {
        this.grpId = grpId;
    }

    /**
     * @return the createTimestamp
     */
    public Timestamp getCreateTimestamp() {
        return createTimestamp;
    }

    /**
     * @param createTimestamp
     *            the createTimestamp to set
     */
    public void setCreateTimestamp(Timestamp createTimestamp) {
        this.createTimestamp = createTimestamp;
    }

    /**
     * @return the updTimestamp
     */
    public Timestamp getUpdTimestamp() {
        return updTimestamp;
    }

    /**
     * @param updTimestamp
     *            the updTimestamp to set
     */
    public void setUpdTimestamp(Timestamp updTimestamp) {
        this.updTimestamp = updTimestamp;
    }

    /**
     * @return the status
     */
    public int getStatus() {
        return status;
    }

    /**
     * @param status
     *            the status to set
     */
    public void setStatus(int status) {
        this.status = status;
    }

}
