package com.endava.amcourse.mvc.service;

import com.endava.amcourse.mvc.model.Task;
import com.endava.amcourse.mvc.model.User;

import java.util.List;

/**
 * Created by pcovaliov on 11/27/2018.
 */
public interface TaskService {

    List<Task> getAllTasks();

    List<Task> getTasksByUser(User user);

    void add(Task task);

    void deleteTaskById(int taskId);

}
