package com.endava.amcourse.mvc.service.impl;

import com.endava.amcourse.mvc.dao.TaskDao;
import com.endava.amcourse.mvc.model.Task;
import com.endava.amcourse.mvc.model.User;
import com.endava.amcourse.mvc.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by pcovaliov on 11/27/2018.
 */

@RequiredArgsConstructor
@Service
@Transactional
public class TaskServiceImpl implements TaskService {

    private final TaskDao taskDao;

    @Override
    public List<Task> getAllTasks() {
        return taskDao.getAllTasks() ;
    }

    @Override
    public List<Task> getTasksByUser(User user) {
        return taskDao.getTasksByUser(user);
    }

    @Override
    public void add(Task task) {
        taskDao.persist(task);
    }

    @Override
    public void deleteTaskById(int taskId) {
        taskDao.deleteTaskById(taskId);
    }
}
