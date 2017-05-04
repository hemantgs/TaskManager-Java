package com.tenmiles.model;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "task_dur")
public class TaskDurEO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DUR_ID")
    private int durId;

    @ManyToOne
    @JoinColumn(name = "task_id")
    private TaskEO taskEo;

    @Column(name = "DURATION")
    private long duration;

    @Column(name = "START_TIMESTAMP")
    private long starteTimestamp;

    @Column(name = "END_TIMESTAMP")
    private long endTimestamp;

    @Column(name = "CREAT_TIMESTAMP")
    private Timestamp createTimestamp;

    @Column(name = "UPD_TIMESTAMP")
    private Timestamp updTimestamp;

    @Column(name = "CURR_DATE")
    private Date currDate;

    /**
     * @return the durId
     */
    public int getDurId() {
        return durId;
    }

    /**
     * @param durId
     *            the durId to set
     */
    public void setDurId(int durId) {
        this.durId = durId;
    }

    /**
     * @return the taskEo
     */
    public TaskEO getTaskEo() {
        return taskEo;
    }

    /**
     * @param taskEo
     *            the taskEo to set
     */
    public void setTaskEo(TaskEO taskEo) {
        this.taskEo = taskEo;
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
     * @return the starteTimestamp
     */
    public long getStarteTimestamp() {
        return starteTimestamp;
    }

    /**
     * @param starteTimestamp
     *            the starteTimestamp to set
     */
    public void setStarteTimestamp(long starteTimestamp) {
        this.starteTimestamp = starteTimestamp;
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

}
