package org.example;

import org.example.repository.BookRepos;
import org.example.storages.StorageBook;
import org.example.tools.Input;
import org.example.tools.impl.ConsoleInput;

public class Main {
    public static void main(String[] args) {

        BookRepos bookRepos = new StorageBook();
        Input input = new ConsoleInput();

        App app = new App(input, bookRepos);
        app.run();
    }
}