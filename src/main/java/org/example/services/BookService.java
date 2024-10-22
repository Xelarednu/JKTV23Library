package org.example.services;

import org.example.model.Book;
import org.example.repository.Repository;
import org.example.services.helpers.AppHelperBookInput;

import java.util.List;

public class BookService {
    private final Repository<Book> repository;
    private final AppHelperBookInput appHelperBookInput;
    private final List<Book> books;

    public BookService(List<Book> books, AppHelperBookInput appHelperBookInput, Repository<Book> repository) {
        this.repository = repository;
        this.appHelperBookInput = appHelperBookInput;
        this.books = books;
    }

    public boolean addBook() {
        Book book = appHelperBookInput.createBook();

        if (book != null) {
            books.add(book);
            repository.save(books);
            return true;
        } else {
            return false;
        }
    }

    public void books() {
        appHelperBookInput.printBooks();
    }

    public Repository<Book> getRepository() {
        return repository;
    }
}