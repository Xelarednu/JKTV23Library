package org.example.services;

import org.example.model.User;
import org.example.services.helpers.AppHelperUserDataInput;
import org.example.tools.Input;

import java.util.Scanner;

public class UserService {
    private final Input input;

    public UserService(Input input) {
        this.input = input;
    }

    public boolean addUser (AppHelperUserDataInput appHelperUserDataInput) {
        User user = appHelperUserDataInput.createUser(input);

        return user != null;
    }
}
