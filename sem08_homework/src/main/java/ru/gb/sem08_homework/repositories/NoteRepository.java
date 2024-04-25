package ru.gb.sem08_homework.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ru.gb.sem08_homework.models.Note;

import java.util.Optional;

/**
 * Интерфейс для управления базой данных модели Note
 */
@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {
    Optional<Note> findById(Long id);
}
