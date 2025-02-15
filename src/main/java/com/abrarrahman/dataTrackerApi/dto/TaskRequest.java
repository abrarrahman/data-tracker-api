package com.abrarrahman.dataTrackerApi.dto;

import lombok.Getter;

@Getter
public class TaskRequest {
    private String title;
    private String description;

    public TaskRequest() {
    }

    public TaskRequest(String title, String description) {
        this.title = title;
        this.description = description;
    }
}
