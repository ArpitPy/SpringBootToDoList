package com.example.todo.model;

import java.time.LocalDateTime;
import java.util.UUID;

public class Task {
    private final String id;
    private String title;
    private String description;
    private boolean completed;
    private LocalDateTime createdAt;

    //constructor
    public Task(String title, String description) {
        this.id = UUID.randomUUID().toString();
        this.title = title;
        this.description = description;
        this.completed = false;
        this.createdAt = LocalDateTime.now();
    }

    //getter functions here:
    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescrpition() {
        return description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    //setter functions
    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescrpition(String descrpition) {
        this.description = descrpition;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}