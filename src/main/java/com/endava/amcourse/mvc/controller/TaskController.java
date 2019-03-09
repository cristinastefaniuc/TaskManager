package com.endava.amcourse.mvc.controller;

import com.endava.amcourse.mvc.model.Task;
import com.endava.amcourse.mvc.model.User;
import com.endava.amcourse.mvc.service.TaskService;
import com.endava.amcourse.mvc.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by pcovaliov on 11/27/2018.
 */

@Controller
@RequestMapping(value = "/task")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;
    private final UserService userService;

    @RequestMapping(value = "/show-tasks", method = GET)
    public String showTasks(Model model) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = ((UserDetails) principal).getUsername();
        User user = userService.getUserByUsername(username);
        model.addAttribute("taskList", taskService.getTasksByUser(user));
        return "tasks";
    }

    @RequestMapping(value = "/add-task", method = GET)
    public String showTaskForm() {
        return "tasks";
    }

    @RequestMapping(value = "/add-task", method = POST)
    public String getTask(@ModelAttribute("task") Task task){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = ((UserDetails) principal).getUsername();
        User user = userService.getUserByUsername(username);
        task.setUser(user);
        taskService.add(task);
        return "redirect:/task/show-tasks";
    }

    @RequestMapping(value = "/delete-by-id/{taskId}", method = GET)
    public String removeTask(@PathVariable int taskId){
        taskService.deleteTaskById(taskId);
        return "redirect:/task/show-tasks";
    }
}
