package org.example.services;

import org.example.model.Registry;
import org.example.repository.Repository;
import org.example.services.helpers.AppHelperRegistryInput;

import java.util.List;

public class RegistryService {
    private final Repository<Registry> repository;
    private final AppHelperRegistryInput appHelperRegistryInput;
    private final List<Registry> registries;

    public RegistryService(List<Registry> registries, Repository<Registry> repository, AppHelperRegistryInput appHelperRegistryInput) {
        this.repository = repository;
        this.appHelperRegistryInput = appHelperRegistryInput;
        this.registries = registries;
    }

    public boolean bookBorrow() {
        Registry registry = appHelperRegistryInput.bookBorrow();

        if (registry != null) {
            registries.add(registry);
            repository.save(registries);
        }

        return registry != null;
    }

    public boolean returnBook() {
        return appHelperRegistryInput.returnBookDialog();
    }
}