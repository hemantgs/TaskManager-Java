package com.tenmiles.model;

import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "task_list")
public class TaskEO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TASK_ID")
    private int taskId;

    @Column(name = "TASK_NAME")
    private String taskName;

    @Column(name = "GROUP_ID")
    private int grpId;

    @Column(name = "CREAT_TIME_STMP")
    private Timestamp createTimestamp;

    @Column(name = "UPD_TIME_STMP")
    private Timestamp updTimestamp;

    @OneToMany(mappedBy = "taskEo", fetch = FetchType.EAGER, orphanRemoval = true)
    private Set<TaskDurEO> taskDurations;

    @Column(name = "STATUS")
    private int status;

    /**
     * @return the taskDurations
     */
    public Set<TaskDurEO> getTaskDurations() {
        return taskDurations;
    }

    /**
     * @param taskDurations
     *            the taskDurations to set
     */
    public void setTaskDurations(Set<TaskDurEO> taskDurations) {
        this.taskDurations = taskDurations;
    }

    /**
     * @return the taskId
     */
    public int getTaskId() {
        return taskId;
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
     * @param status the status to set
     */
    public void setStatus(int status) {
        this.status = status;
    }

    

}
