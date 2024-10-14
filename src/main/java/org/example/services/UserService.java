package org.example.services;

import org.example.model.User;
import org.example.services.helpers.AppHelperUserDataInput;

import java.util.Scanner;

public class UserService {
    private final Scanner scanner;

    public UserService(Scanner scanner) {
        this.scanner = scanner;
    }

    public boolean addUser (AppHelperUserDataInput appHelperUserDataInput) {
        User user = appHelperUserDataInput.createUser(scanner);

        return user != null;
    }
}
