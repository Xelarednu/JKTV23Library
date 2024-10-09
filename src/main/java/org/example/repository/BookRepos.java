package org.example.repository;

import org.example.model.Book;

import java.util.List;

public interface BookRepos {
    void saveBook(Book book);

    List<Book> loadBooks();
}