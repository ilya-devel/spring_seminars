package ru.gb.sem08_homework.services.implementation;

import lombok.RequiredArgsConstructor;
import ru.gb.sem08_homework.annotations.TrackUserAction;
import ru.gb.sem08_homework.models.Note;
import ru.gb.sem08_homework.repositories.NoteRepository;
import ru.gb.sem08_homework.services.INoteService;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Сервис обращений к базе данных с базовыми операциями CRUD
 */
@Service
@RequiredArgsConstructor
public class NoteService implements INoteService {
    private final NoteRepository noteRepository;

    /**
     * Запрос всех заметок из базы
     * @return возвращает список заметок
     */
    @Override
    @TrackUserAction
    public List<Note> findAllNotes (){return noteRepository.findAll();}

    /**
     * Сохранение заметки в базу данных
     * @param note объект заметки для сохранения
     * @return возвращает сохранённую заметку
     */
    @Override
    @TrackUserAction
    public Note addNote(Note note) {return noteRepository.save(note);}

    /**
     * Поиск заметки в базе по ID
     * @param id идентификационный номер для поиска
     * @return возвращает найденную заметку или null
     */
    @Override
    @TrackUserAction
    public Note findNoteById(Long id) {return noteRepository.findById(id).get();}

    /**
     * Обновление заметки
     * @param note объект заметки для обновления
     * @return возвращает обновлённую заметку
     */
    @Override
    @TrackUserAction
    public Note updateNote(Note note) {return noteRepository.save(note);}

    /**
     * Удаление заметки по идентификационному номеру
     * @param id идентификационный номер заметки
     * @return возвращает объект удалённой заметки
     */
    @Override
    @TrackUserAction
    public Note removeNote(Long id) {
        Note note = noteRepository.findById(id).get();
        noteRepository.deleteById(id);
        return note;
    }

}
