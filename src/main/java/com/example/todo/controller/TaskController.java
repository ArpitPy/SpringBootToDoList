package com.example.todo.controller;

import com.example.todo.model.Task;
import com.example.todo.service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<Task> createTask(@RequestBody Task request) {
        Task created = taskService.createTask(request.getTitle(), request.getDescrpition());
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    //get all tasks
    @GetMapping
    public ResponseEntity<List<Task>> getAllTasks() {
        return ResponseEntity.ok(taskService.getAllTasks());
    }

    //get tasks by id
    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable String id) {
        Task task = taskService.getTaskByIdOrThrow(id);
        return ResponseEntity.ok(task);
    }

    //update task by id
    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable String id, @RequestBody Task request) {
        Task updated = taskService.updateTask(id, request.getTitle(), request.getDescrpition(), request.isCompleted());
        return ResponseEntity.ok(updated);
    }

    //delete a task
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable String id) {
        taskService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }
}
