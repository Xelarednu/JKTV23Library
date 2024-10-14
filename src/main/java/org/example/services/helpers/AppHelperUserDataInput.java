package org.example.services.helpers;

import org.example.model.User;

import java.util.Scanner;

public class AppHelperUserDataInput {

    public User createUser (Scanner scanner) {
        User user = new User();
        System.out.println("========= New user =========");
        System.out.println("User first name: ");
        user.setFirstName(scanner.nextLine());
        System.out.println("User last name: ");
        user.setLastName(scanner.nextLine());
        System.out.println("User email: ");
        user.setEmail(scanner.nextLine());
        System.out.println("User phone number: ");
        user.setPhoneNumber(scanner.nextLine());

        return user;
    }
}
