package com.example.todo.controller;

import com.example.todo.model.Task;
import com.example.todo.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.todo.dto.TaskRequestDTO;
import com.example.todo.dto.TaskResponseDTO;

import java.util.*;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    //create task
    @PostMapping
    public ResponseEntity<TaskResponseDTO> createTask(@Valid @RequestBody TaskRequestDTO request) {
        Task task = taskService.createTask(request.getTitle(), request.getDescrpition());
        TaskResponseDTO response = new TaskResponseDTO(
                task.getId(),
                task.getTitle(),
                task.getDescrpition(),
                task.isCompleted(),
                task.getCreatedAt().toString()
        );
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    //get all tasks
    @GetMapping
    public ResponseEntity<List<TaskResponseDTO>> getAllTasks() {
        List<TaskResponseDTO> response = taskService.getAllTasks().stream().map(
                task -> new TaskResponseDTO(
                        task.getId(),
                        task.getTitle(),
                        task.getDescrpition(),
                        task.isCompleted(),
                        task.getCreatedAt().toString()
                )
        ).toList();
        return ResponseEntity.ok(response);
    }

    //get tasks by id
    @GetMapping("/{id}")
    public ResponseEntity<TaskResponseDTO> getTaskById(@PathVariable String id) {
        Task task = taskService.getTaskByIdOrThrow(id);
        TaskResponseDTO response = new TaskResponseDTO(
                task.getId(),
                task.getTitle(),
                task.getDescrpition(),
                task.isCompleted(),
                task.getCreatedAt().toString()
        );
        return ResponseEntity.ok(response);
    }

    //update task by id
    @PutMapping("/{id}")
    public ResponseEntity<TaskResponseDTO> updateTask(@PathVariable String id, @Valid @RequestBody TaskRequestDTO request) {
        Task task = taskService.updateTask(id, request.getTitle(), request.getDescrpition(), request.isCompleted());
        TaskResponseDTO response = new TaskResponseDTO(
                task.getId(),
                task.getTitle(),
                task.getDescrpition(),
                task.isCompleted(),
                task.getCreatedAt().toString()
        );
        return ResponseEntity.ok(response);
    }

    //delete a task
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable String id) {
        taskService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }
}
