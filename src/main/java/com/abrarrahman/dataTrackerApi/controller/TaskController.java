package com.abrarrahman.dataTrackerApi.controller;

import com.abrarrahman.dataTrackerApi.dto.TaskRequest;
import com.abrarrahman.dataTrackerApi.model.Task;
import com.abrarrahman.dataTrackerApi.service.TaskService;
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

    @PostMapping("/")
    public Task createTask(@RequestBody TaskRequest task) {
        return taskService.createTask(task);
    }

    @PutMapping("/{id}")
    public Task updateTask(@PathVariable Long id, @RequestBody TaskRequest task) {
        System.out.println("updating task with id: " + id);
        return taskService.updateTaskById(id, task);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
    }

    @PostMapping("/{id}/complete")
    public Task markComplete(@PathVariable Long id) {
        return taskService.updateTaskCompletionStatus(id, true);
    }

    @PostMapping("/{id}/incomplete")
    public Task markIncomplete(@PathVariable Long id) {
        return taskService.updateTaskCompletionStatus(id, false);
    }
}

