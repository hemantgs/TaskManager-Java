package com.tenmiles.dto;

public class TaskDuration {

    private int taskId;
    private long startTimestamp;
    private long endTimestamp;
    private long duration;
    private String startDateString;
    private String endDateString;

    /**
     * @return the taskId
     */
    public int getTaskId() {
        return taskId;
    }

    /**
     * @return the startTimestamp
     */
    public long getStartTimestamp() {
        return startTimestamp;
    }

    /**
     * @param startTimestamp
     *            the startTimestamp to set
     */
    public void setStartTimestamp(long startTimestamp) {
        this.startTimestamp = startTimestamp;
    }

    /**
     * @return the endTimestamp
     */
    public long getEndTimestamp() {
        return endTimestamp;
    }

    /**
     * @param endTimestamp
     *            the endTimestamp to set
     */
    public void setEndTimestamp(long endTimestamp) {
        this.endTimestamp = endTimestamp;
    }

    /**
     * @param taskId
     *            the taskId to set
     */
    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    /**
     * @return the duration
     */
    public long getDuration() {
        return duration;
    }

    /**
     * @param duration
     *            the duration to set
     */
    public void setDuration(long duration) {
        this.duration = duration;
    }

    /**
     * @return the startDateString
     */
    public String getStartDateString() {
        return startDateString;
    }

    /**
     * @param startDateString
     *            the startDateString to set
     */
    public void setStartDateString(String startDateString) {
        this.startDateString = startDateString;
    }

    /**
     * @return the endDateString
     */
    public String getEndDateString() {
        return endDateString;
    }

    /**
     * @param endDateString
     *            the endDateString to set
     */
    public void setEndDateString(String endDateString) {
        this.endDateString = endDateString;
    }

}
