package org.example.services;

import org.example.model.User;
import org.example.repository.Repository;
import org.example.services.helpers.AppHelperUserInput;
import org.example.interfaces.Input;

import java.util.List;

public class UserService {
    private final Input input;
    private final Repository<User> repository;
    private final AppHelperUserInput appHelperUserInput;
    private final List<User> users;

    public UserService(List<User> users, Input input, AppHelperUserInput appHelperUserInput, Repository<User> repository) {
        this.input = input;
        this.repository = repository;
        this.appHelperUserInput = appHelperUserInput;
        this.users = users;
    }

    public boolean addUser () {
        User user = appHelperUserInput.createUser(input);

        if (user != null) {
            users.add(user);
            repository.save(users);
            return true;
        } else {
            return false;
        }
    }

    public void users(List<User> users) {
        appHelperUserInput.printUsers(users);
    }

    public Repository<User> getRepository() {
        return repository;
    }
}