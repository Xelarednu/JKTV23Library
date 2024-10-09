package org.example.services;

import org.example.model.Book;
import org.example.services.helpers.BookDataInput;

import java.util.Scanner;

public class BookService {
    private final Scanner scanner;

    public BookService(Scanner scanner) {
        this.scanner = scanner;
    }

    public boolean addBook(BookDataInput bookDataInput) {
        Book book = bookDataInput.createBook(scanner);

        if (book != null) {

            return true;
        }

        return false;
    }
}