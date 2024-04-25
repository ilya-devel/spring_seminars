package ru.gb.sem08_homework.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;


/**
 * Модель заметки
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "notes")
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 50)
    private String title;
    @Column(nullable = false, length = 200)
    private String description;
    @CreatedDate
    @Column(name = "create_date", updatable = false)
    private LocalDateTime createDate = LocalDateTime.now();

    public Note(String title, String description) {
        this.title = title;
        this.description = description;
    }
}
