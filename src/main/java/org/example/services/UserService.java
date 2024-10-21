package org.example.services;

import org.example.model.User;
import org.example.repository.Repository;
import org.example.services.helpers.AppHelperUserInput;
import org.example.interfaces.Input;

public class UserService {
    private final Input input;
    private final Repository<User> repository;
    private final AppHelperUserInput appHelperUserInput;

    public UserService(Input input, AppHelperUserInput appHelperUserInput, Repository<User> repository) {
        this.input = input;
        this.repository = repository;
        this.appHelperUserInput = appHelperUserInput;
    }

    public boolean addUser () {
        User user = appHelperUserInput.createUser(input);

        if (user != null) {
            repository.save(user);
        }

        return user != null;
    }

    public void users(Repository<User> repositoryUser) {
        appHelperUserInput.printUsers(repositoryUser.getEntities());
    }

    public Repository<User> getRepository() {
        return repository;
    }
}
