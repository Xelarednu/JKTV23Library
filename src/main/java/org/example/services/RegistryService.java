package org.example.services;

import org.example.model.Book;
import org.example.model.Registry;
import org.example.repository.Repository;
import org.example.interfaces.Input;
import org.example.services.helpers.AppHelperBookInput;
import org.example.services.helpers.AppHelperRegistryInput;

public class RegistryService {
    private final Input input;
    private final Repository<Registry> repository;
    private final AppHelperRegistryInput appHelperRegistryInput;

    public RegistryService(Input input, Repository<Registry> repository, AppHelperRegistryInput appHelperRegistryInput) {
        this.input = input;
        this.repository = repository;
        this.appHelperRegistryInput = appHelperRegistryInput;
    }

    public boolean bookBorrow(UserService userService, BookService bookService) {
        Registry registry = appHelperRegistryInput.bookBorrow(input, userService, bookService);

        if (registry != null) {
            repository.save(registry);
        }

        return registry != null;
    }

    public boolean returnBook(AppHelperRegistryInput appHelperRegistryInput, BookService bookService) {
        return appHelperRegistryInput.returnBookDialog(input, repository);
    }
}