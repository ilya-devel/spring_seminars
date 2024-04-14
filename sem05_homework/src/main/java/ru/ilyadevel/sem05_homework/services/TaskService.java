package ru.ilyadevel.sem05_homework.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ilyadevel.sem05_homework.model.Task;
import ru.ilyadevel.sem05_homework.repository.TaskRepository;

@Service
@AllArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;

    public Iterable<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task addTask(Task task) {
        taskRepository.save(task);
        return task;
    }

    public Iterable<Task> getTaskByStatus(Task.TaskStatus status) {
        return taskRepository.findByStatus(status);
    }

    public Task updateTaskStatus(Long id, Task task) {

        try {
            Task task1 = taskRepository.findById(id).get();
            if (task1 == null) return null;
            task1.setDescription(task.getDescription());
            task1.setStatus(task.getStatus());
            taskRepository.save(task1);
            return task1;
        } catch (Exception e) {
            return null;
        }
    }

    public Task deleteTask(Long id) {
        try {
            Task task = taskRepository.findById(id).get();
            taskRepository.deleteById(id);
            return task;
        } catch (Exception e) {
            return null;
        }
    }
}
