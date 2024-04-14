package ru.ilyadevel.sem05_homework.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.ilyadevel.sem05_homework.model.Task;
import ru.ilyadevel.sem05_homework.services.TaskService;

@RestController
@RequestMapping("/tasks")
@AllArgsConstructor
public class TaskController {
    private final TaskService taskService;

    @GetMapping
    public Iterable<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @PostMapping()
    public Task addTask(@RequestBody Task task) {
        return taskService.addTask(task);
    }

    @GetMapping("/status/{status}")
    public Iterable<Task> getTaskByStatus(@PathVariable Task.TaskStatus status) {
        return taskService.getTaskByStatus(status);
    }

    @PutMapping("/{id}")
    public Task updateTaskStatus(@PathVariable Long id, @RequestBody Task task) {
        Task updTask =  taskService.updateTaskStatus(id, task);
        if (updTask != null) return updTask;
        throw new RuntimeException("Task not found");
    }

    @DeleteMapping("/{id}")
    public Task deleteTask(@PathVariable Long id) {
        Task result = taskService.deleteTask(id);
        if (result != null) return result;
        throw new RuntimeException("Task not found");
    }
}
