package com.endava.amcourse.mvc.dao;

import com.endava.amcourse.mvc.model.Task;
import com.endava.amcourse.mvc.model.User;

import java.util.List;

/**
 * Created by pcovaliov on 11/27/2018.
 */
public interface TaskDao {

    List<Task> getAllTasks();

    List<Task> getTasksByUser(User user);

    void persist(Task task);

    void deleteTaskById(int taskId);

}
