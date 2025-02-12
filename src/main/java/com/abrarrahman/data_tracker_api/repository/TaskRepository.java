package com.abrarrahman.data_tracker_api.repository;

import com.abrarrahman.data_tracker_api.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
