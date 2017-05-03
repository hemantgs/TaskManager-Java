package com.tenmiles.dao;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tenmiles.dto.Task;
import com.tenmiles.dto.TaskDuration;
import com.tenmiles.model.TaskDurEO;
import com.tenmiles.model.TaskEO;

@Service
@Repository
@Transactional
public class TaskDao implements ITaskDao {
    @PersistenceContext
    private EntityManager entityManager;

    public List<TaskEO> getTaskList() {
        Query query = entityManager.createNativeQuery("SELECT * FROM task_list", TaskEO.class);
        List<TaskEO> taskList = query.getResultList();
        return taskList;
    }

    public void addtask(Task task) {
        TaskEO taskEo = new TaskEO();
        taskEo.setTaskName(task.getTaskName());
        taskEo.setGrpId(task.getGrpId());
        taskEo.setCreateTimestamp(new Timestamp(System.currentTimeMillis()));
        taskEo.setUpdTimestamp(new Timestamp(System.currentTimeMillis()));
        entityManager.merge(taskEo);
    }

    public void addtaskDur(TaskDuration taskDur) {
        TaskDurEO dur = new TaskDurEO();
        dur.setDuration(taskDur.getDuration());

        dur.setStarteTimestamp(taskDur.getStartTimestamp());
        dur.setEndTimestamp(taskDur.getEndTimestamp());
        dur.setCreateTimestamp(new Timestamp(System.currentTimeMillis()));
        dur.setUpdTimestamp(new Timestamp(System.currentTimeMillis()));
        TaskEO taskEo = entityManager.find(TaskEO.class, taskDur.getTaskId());
        dur.setTaskEo(taskEo);
        entityManager.merge(dur);
    }

    public void deleteTask(int taskId) {
        TaskEO taskEo = entityManager.find(TaskEO.class, taskId);
        entityManager.remove(taskEo);

    }

    public TaskEO getTaskDetails(int taskId) {

        TaskEO taskEo = entityManager.find(TaskEO.class, taskId);
        return taskEo;
    }

    public void toggleStatus(Task task) {
        TaskEO taskEo = entityManager.find(TaskEO.class, task.getTaskId());
        taskEo.setStatus(task.getStatus());
        entityManager.merge(taskEo);

    }

}
