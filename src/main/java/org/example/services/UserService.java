package org.example.services;

import org.example.model.User;
import org.example.repository.Repository;
import org.example.services.helpers.AppHelperUserDataInput;
import org.example.tools.Input;

import java.util.Scanner;

public class UserService {
    private final Input input;
    private final Repository<User> repository;

    public UserService(Input input, Repository<User> repository) {
        this.input = input;
        this.repository = repository;
    }

    public boolean addUser (AppHelperUserDataInput appHelperUserDataInput) {
        User user = appHelperUserDataInput.createUser(input);

        if (user != null) {
            repository.save(user);
        }

        return user != null;
    }
}
