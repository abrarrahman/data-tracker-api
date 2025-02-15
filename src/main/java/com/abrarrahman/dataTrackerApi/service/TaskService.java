package com.abrarrahman.dataTrackerApi.service;

import com.abrarrahman.dataTrackerApi.dto.TaskRequest;
import com.abrarrahman.dataTrackerApi.model.Task;
import com.abrarrahman.dataTrackerApi.repository.TaskRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task createTask(TaskRequest task) {
        return taskRepository.save(new Task(task.getTitle(), task.getDescription()));
    }

    @Transactional
    public Task updateTaskById(Long id, TaskRequest updatedTask) {
        return taskRepository.findById(id)
                .map(task -> {
                    task.setTitle(updatedTask.getTitle());
                    task.setDescription(updatedTask.getDescription());
                    return taskRepository.save(task);
                })
                .orElseThrow(() -> new EntityNotFoundException("Task not found with id: " + id));
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    public Task updateTaskCompletionStatus(Long id, boolean isCompleted) {
        return taskRepository.findById(id)
                .map(task -> {
                    task.setCompleted(isCompleted);
                    task.setCompletedAt(isCompleted ? LocalDateTime.now() : null);
                    return taskRepository.save(task);
                })
                .orElseThrow(() -> new EntityNotFoundException("Task not found with id: " + id));
    }
}
