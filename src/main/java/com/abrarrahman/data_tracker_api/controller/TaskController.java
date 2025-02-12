package com.abrarrahman.data_tracker_api.controller;

import com.abrarrahman.data_tracker_api.model.Task;
import com.abrarrahman.data_tracker_api.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/")
    public List<Task> getTasks() {
        return taskService.getAllTasks();
    }

    @GetMapping("/hello")
    public String getHello() {
        System.out.println("Test endpoint called!");
        return "hello from tasks api some change";
    }

    @PostMapping("/")
    public Task createTask(@RequestBody Task task) {
        return taskService.createTask(new Task(task.getTitle(), task.getDescription()));
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
    }
}

