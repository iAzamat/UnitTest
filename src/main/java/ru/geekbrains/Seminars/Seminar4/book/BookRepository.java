package ru.geekbrains.Seminars.Seminar4.book;

import java.util.List;

public interface BookRepository {
    Book findById(String id);
    List<Book> findAll();
}
