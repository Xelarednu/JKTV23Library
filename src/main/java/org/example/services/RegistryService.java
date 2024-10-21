package org.example.services;

import org.example.model.Book;
import org.example.model.Registry;
import org.example.model.User;
import org.example.repository.Repository;
import org.example.interfaces.Input;
import org.example.services.helpers.AppHelperBookInput;
import org.example.services.helpers.AppHelperRegistryInput;

import java.util.List;

public class RegistryService {
    private final Input input;
    private final Repository<Registry> repository;
    private final AppHelperRegistryInput appHelperRegistryInput;
    private final List<Book> books;
    private final List<User> users;
    private final List<Registry> registries;


    public RegistryService(List<Registry> registries, List<User> users, List<Book> books, Input input, Repository<Registry> repository, AppHelperRegistryInput appHelperRegistryInput) {
        this.input = input;
        this.repository = repository;
        this.appHelperRegistryInput = appHelperRegistryInput;
        this.books = books;
        this.users = users;
        this.registries = registries;
    }

    public boolean bookBorrow(List<Book> books, UserService userService, BookService bookService) {
        Registry registry = appHelperRegistryInput.bookBorrow(books, users, registries, input, userService, bookService);

        if (registry != null) {
            registries.add(registry);
            repository.save(registries);
        }

        return registry != null;
    }

    public boolean returnBook(Input input, List<Registry> registries) {
        return appHelperRegistryInput.returnBookDialog(input, registries);
    }
}