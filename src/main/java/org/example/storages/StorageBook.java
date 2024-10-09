package org.example.storages;

import org.example.model.Book;
import org.example.repository.BookRepos;

import java.util.List;

public class StorageBook implements BookRepos {

    @Override
    public void saveBook(Book book) {

    }

    @Override
    public List<Book> loadBooks() {
        return List.of();
    }
}