package ru.ilyadevel.sem05_homework.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Type;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "tasks")
@AllArgsConstructor
@NoArgsConstructor
public class Task {
    public enum TaskStatus {
        NOT_STARTED,
        IN_PROGRESS,
        COMPLETED
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 300)
    private String description;

    public Task(String description) {
        this.description = description;
    }

    @Enumerated(value = EnumType.STRING)
    @Column(nullable = false, length = 20, columnDefinition = "varchar(15) default 'NOT_STARTED'")
    private TaskStatus status = TaskStatus.NOT_STARTED;

    @CreatedDate
    @Column(name = "create_date", updatable = false)
    private LocalDateTime createDate = LocalDateTime.now();
}
