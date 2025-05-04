package com.example.todo.service;

import com.example.todo.exception.TaskNotFoundException;
import com.example.todo.model.Task;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TaskService {
    private final Map<String, Task> taskMap = new HashMap<>();

    //error handling
    public Task getTaskByIdOrThrow(String id) {
        Task task = taskMap.get(id);
        if (task == null) {
            throw new TaskNotFoundException(id);
        }
        return task;
    }

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
    public Task updateTask(String id, String title, String description, boolean completed) {
        Task task = getTaskByIdOrThrow(id);
        task.setTitle(title);
        task.setDescrpition(description);
        task.setCompleted(completed);
        return task;
    }

    //delete task
    public void deleteTask(String id) {
        Task task = getTaskByIdOrThrow(id);
        taskMap.remove(id);
    }
}
