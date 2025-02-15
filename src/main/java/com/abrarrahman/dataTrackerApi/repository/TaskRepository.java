package com.abrarrahman.dataTrackerApi.repository;

import com.abrarrahman.dataTrackerApi.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
