package com.example.todo.dto;

public class TaskResponseDTO {
    private String id;
    private String title;
    private String description;
    private boolean completed;
    private String createdAt;

    public TaskResponseDTO(String id, String title, String description, boolean completed, String createdAt) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.completed = completed;
        this.createdAt = createdAt;
    }

    //getters (setters won't be needed by response object
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

    public String getCreatedAt() {
        return createdAt;
    }
}
