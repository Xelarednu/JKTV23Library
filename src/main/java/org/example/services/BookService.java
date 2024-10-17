package org.example.services;

import org.example.model.Book;
import org.example.repository.Repository;
import org.example.services.helpers.AppHelperBookDataInput;
import org.example.tools.Input;

public class BookService {
    private final Input input;
    private final Repository<Book> repository;

    public BookService(Input input, Repository<Book> repository) {
        this.input = input;
        this.repository = repository;
    }

    public boolean addBook(AppHelperBookDataInput appHelperBookDataInput) {
        Book book = appHelperBookDataInput.createBook(input);

        if (book != null) {
            repository.save(book);
        }

        return book != null;
    }

    public void books(AppHelperBookDataInput appHelperBookDataInput, Repository<Book> repositoryBook) {
        appHelperBookDataInput.printBooks(repositoryBook.getEntities());
    }
}