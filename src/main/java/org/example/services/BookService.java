package org.example.services;

import org.example.model.Book;
import org.example.repository.BookRepos;
import org.example.services.helpers.AppHelperBookDataInput;
import org.example.tools.Input;

public class BookService {
    private final Input input;
    private final BookRepos bookRepos;

    public BookService(Input input, BookRepos bookRepos) {
        this.input = input;
        this.bookRepos = bookRepos;
    }

    public boolean addBook(AppHelperBookDataInput appHelperBookDataInput) {
        Book book = appHelperBookDataInput.createBook(input);

        if (book != null) {
            bookRepos.saveBook(book);
        }

        return book != null;
    }
}