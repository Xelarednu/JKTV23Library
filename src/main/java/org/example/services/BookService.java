package org.example.services;

import org.example.model.Book;
import org.example.repository.Repository;
import org.example.services.helpers.AppHelperBookInput;
import org.example.interfaces.Input;

import java.util.List;

public class BookService {
    private final Input input;
    private final Repository<Book> repository;
    private final AppHelperBookInput appHelperBookInput;
    private final List<Book> books;

    public BookService(List<Book> books, Input input, AppHelperBookInput appHelperBookInput, Repository<Book> repository) {
        this.input = input;
        this.repository = repository;
        this.appHelperBookInput = appHelperBookInput;
        this.books = books;
    }

    public boolean addBook() {
        Book book = appHelperBookInput.createBook(input);

        if (book != null) {
            books.add(book);
            repository.save(books);
            return true;
        } else {
            return false;
        }
    }

    public void books(List<Book> books) {
        appHelperBookInput.printBooks(books);
    }

    public Repository<Book> getRepository() {
        return repository;
    }
}