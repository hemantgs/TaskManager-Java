package com.tenmiles.dto;

import java.util.Date;

public class TaskDuration {

    private int taskId;
    private long startTimestamp;
    private long endTimestamp;
    private long duration;
    private String startTimeString;
    private String endTimeString;
    private Date currDate;
    private String timeGap;

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
     * @return the startTimeString
     */
    public String getStartTimeString() {
        return startTimeString;
    }

    /**
     * @param startTimeString
     *            the startTimeString to set
     */
    public void setStartTimeString(String startTimeString) {
        this.startTimeString = startTimeString;
    }

    /**
     * @return the endTimeString
     */
    public String getEndTimeString() {
        return endTimeString;
    }

    /**
     * @param endTimeString
     *            the endTimeString to set
     */
    public void setEndTimeString(String endTimeString) {
        this.endTimeString = endTimeString;
    }

    /**
     * @return the currDate
     */
    public Date getCurrDate() {
        return currDate;
    }

    /**
     * @param currDate
     *            the currDate to set
     */
    public void setCurrDate(Date currDate) {
        this.currDate = currDate;
    }

    /**
     * @return the timeGap
     */
    public String getTimeGap() {
        return timeGap;
    }

    /**
     * @param timeGap
     *            the timeGap to set
     */
    public void setTimeGap(String timeGap) {
        this.timeGap = timeGap;
    }

}
