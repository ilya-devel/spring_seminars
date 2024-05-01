package ru.gb.homework.book_info.services;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import ru.gb.homework.book_info.models.Book;
import ru.gb.homework.book_info.repositories.BookRepository;

@Service
@AllArgsConstructor
public class BookService {
    private BookRepository bookRepository;

    public List<Book> getAllBooks() {return bookRepository.findAll();}
    public Book getBookById(Long id) {return bookRepository.findById(id).get();}
    public Book addBook(Book book) {return bookRepository.save(book);}
    public Book updateBook(Book book, Long id) {
        Book fBook = bookRepository.findById(id).get();
        fBook.setAuthor(book.getAuthor());
        fBook.setTitle(book.getTitle());
        fBook.setDescription(book.getDescription());
        bookRepository.save(fBook);
        return fBook;
    }
    public Book removeBook (Long id) {
        Book book = bookRepository.findById(id).get();
        bookRepository.deleteById(id);
        return book;
    }
}
