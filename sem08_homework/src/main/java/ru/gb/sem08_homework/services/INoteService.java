package ru.gb.sem08_homework.services;

import java.util.List;

import ru.gb.sem08_homework.models.Note;

/**
 * Список базовых операций обязатеьлных для сервиса заметок
 */
public interface INoteService {
    public List<Note> findAllNotes ();
    public Note addNote(Note note);
    public Note findNoteById(Long id);
    public Note updateNote(Note note);
    public Note removeNote(Long id);
}
