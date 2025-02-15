package com.abrarrahman.dataTrackerApi.model;

import java.time.LocalDateTime;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column
    private String description;

    @Column
    private boolean completed;

    @Column
    private LocalDateTime completedAt;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    public Task() {
    }

    public Task(String title, String description) {
        this.title = title;
        this.description = description;
        this.completed = false;
        this.createdAt = LocalDateTime.now();
    }
}
