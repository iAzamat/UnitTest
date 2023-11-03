package ru.geekbrains.Homeworks.Homework4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.geekbrains.Homeworks.Homework4.book.Book;
import ru.geekbrains.Homeworks.Homework4.book.BookRepository;
import ru.geekbrains.Homeworks.Homework4.book.BookService;
import ru.geekbrains.Homeworks.Homework4.book.InMemoryBookRepository;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;


public class BookServiceTest {
    private BookRepository bookRepository;
    private BookService bookService;

    @BeforeEach
    public void setUp() {
        bookRepository = mock(InMemoryBookRepository.class);
        bookService = new BookService(bookRepository);
    }

    @Test
    public void testFindBookById() {
        Book book = new Book("1", "Book1", "Author1");
        when(bookRepository.findById("1")).thenReturn(book);
        Book testBook = bookService.findBookById("1");
        assertEquals(book, testBook);
        verify(bookRepository, times(1)).findById("1");
    }

    @Test
    public void testFindAllBook() {
        Book book1 = new Book("1", "Book1", "Author1");
        Book book2 = new Book("2", "Book2", "Author2");
        List<Book> books = new ArrayList<>(List.of(book1, book2));
        when(bookRepository.findAll()).thenReturn(books);
        List<Book> listOfBooks = bookService.findAllBooks();
        assertEquals(books, listOfBooks);
        verify(bookRepository, times(1)).findAll();
    }
}
