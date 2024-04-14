package ru.ilyadevel.sem05_homework.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ru.ilyadevel.sem05_homework.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
    public Iterable<Task> findByStatus(Task.TaskStatus status);

//    @Modifying
//    @Query("UPDATE task SET status = :status WHERE id = :id")
//    public Task update(Long id, Task.TaskStatus status);
}
