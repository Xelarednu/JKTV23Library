package org.example.services;

import org.example.model.Book;
import org.example.repository.Repository;
import org.example.services.helpers.AppHelperBookInput;
import org.example.interfaces.Input;

public class BookService {
    private final Input input;
    private final Repository<Book> repository;
    private final AppHelperBookInput appHelperBookInput;

    public BookService(Input input, AppHelperBookInput appHelperBookInput, Repository<Book> repository) {
        this.input = input;
        this.repository = repository;
        this.appHelperBookInput = appHelperBookInput;
    }

    public boolean addBook() {
        Book book = appHelperBookInput.createBook(input);

        if (book != null) {
            repository.save(book);
        }

        return book != null;
    }

    public void books(Repository<Book> repositoryBook) {
        appHelperBookInput.printBooks(repositoryBook.getEntities());
    }

    public Repository<Book> getRepository() {
        return repository;
    }
}