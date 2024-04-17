package ru.gb.sem06_homework01.services;

import ru.gb.sem06_homework01.models.Note;

import java.util.List;

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
