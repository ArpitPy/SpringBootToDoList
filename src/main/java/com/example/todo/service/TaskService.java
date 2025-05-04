package com.example.todo.service;

import com.example.todo.model.Task;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TaskService {
    private final Map<String, Task> taskMap = new HashMap<>();

    //create a new task
    public Task createTask(String title, String description) {
        Task task = new Task(title, description);
        taskMap.put(task.getId(), task);
        return task;
    }

    //fetch all tasks
    public List<Task> getAllTasks() {
        return new ArrayList<>(taskMap.values());
    }

    //fetch the task that matches the id
    public Optional<Task> getTaskById(String id) {
        return Optional.ofNullable(taskMap.get(id));
    }

    //update tasks by id
    public Optional<Task> updateTask(String id, String title, String description, boolean completed) {
        Task task = taskMap.get(id);
        if (task != null) {
            task.setTitle(title);
            task.setDescrpition(description);
            task.setCompleted(completed);
            return Optional.of(task);
        }
        return Optional.empty();
    }

    //delete task
    public boolean deleteTask(String id) {
        return taskMap.remove(id) != null;
    }
}
