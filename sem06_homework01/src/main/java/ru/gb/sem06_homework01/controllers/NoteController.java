package ru.gb.sem06_homework01.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.gb.sem06_homework01.models.Note;
import ru.gb.sem06_homework01.services.INoteService;

import java.util.List;

/**
 * Контроллёр API для управления заметками <Note>
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/notes")
public class NoteController {
    private final INoteService noteService;

    /**
     * Получить весь список заметок
     * @return возвращает список
     */
    @GetMapping
    public ResponseEntity<List<Note>> findAll() {
        return new ResponseEntity<>(noteService.findAllNotes(), HttpStatus.OK);
    }

    /**
     * Получить список по ID
     * @param id идентификационный номер заметки
     * @return объект заметки или статус запроса NOT_FOUND, если данного ID нет
     */
    @GetMapping("/{id}")
    public ResponseEntity<Note> findNoteById(@PathVariable Long id) {
        Note note;
        try {
            note = noteService.findNoteById(id);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return new ResponseEntity<>(note, HttpStatus.OK);
    }

    /**
     * Сохраняет заметку в БД
     * @param note тело заметки
     * @return возращает объект заметки
     */
    @PostMapping
    public ResponseEntity<Note> addNote(@RequestBody Note note) {
        return new ResponseEntity<>(noteService.addNote(note), HttpStatus.CREATED);
    }

    /**
     * Обновление заметки
     * @param id идентификационный номер заметки для обновления
     * @param note тело заметки
     * @return объект заметки или статус запроса NOT_FOUND, если данного ID нет
     */
    @PutMapping("/{id}")
    public ResponseEntity<Note> updateNoteWithId(@PathVariable Long id, @RequestBody Note note) {
        Note oldNote;
        try {
            oldNote = noteService.findNoteById(id);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        note.setId(id);
        return new ResponseEntity<>(noteService.updateNote(note), HttpStatus.OK);
    }

    /**
     * Удаление заметки из БД
     * @param id идентификационный номер
     * @return объект заметки или статус запроса NOT_FOUND, если данного ID нет
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Note> deleteNote(@PathVariable Long id) {
        Note note;
        try {
            note = noteService.findNoteById(id);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return new ResponseEntity<>(noteService.removeNote(id), HttpStatus.OK);
    }

}
