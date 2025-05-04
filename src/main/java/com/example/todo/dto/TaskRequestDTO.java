package com.example.todo.dto;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

public class TaskRequestDTO {
    @NotBlank(message = "Title cannot be empty")
    private String title;
    private String description;
    private boolean completed;

    //getter functions here:
    public String getTitle() {
        return title;
    }

    public String getDescrpition() {
        return description;
    }

    public boolean isCompleted() {
        return completed;
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
