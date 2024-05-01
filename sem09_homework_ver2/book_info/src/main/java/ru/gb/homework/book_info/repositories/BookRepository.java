package ru.gb.homework.book_info.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ru.gb.homework.book_info.models.Book;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    public List<Book> findByAuthor(String author);
    public List<Book> findByTitle(String title);
}
