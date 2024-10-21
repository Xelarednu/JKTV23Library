package org.example.services.helpers;

import org.example.model.Book;
import org.example.model.User;
import org.example.interfaces.Input;

import java.util.Arrays;
import java.util.List;


public class AppHelperUserInput {

    public User createUser (Input input) {
        User user = new User();
        System.out.println("========= New user =========");
        System.out.println("User first name: ");
        user.setFirstName(input.nextLine());
        System.out.println("User last name: ");
        user.setLastName(input.nextLine());
        System.out.println("User email: ");
        user.setEmail(input.nextLine());
        System.out.println("User phone number: ");
        user.setPhoneNumber(input.nextLine());

        return user;
    }

    public void printUsers(List<User> entities) {
        if (entities.isEmpty()) {
            System.out.println("Users list is empty");
        } else {
            System.out.println("-------Readers list-------");
            for (int i = 0; i < entities.size(); i++) {
                System.out.printf("%s %n %s %n %s %n %s", i + 1, entities.get(i).getFirstName(), entities.get(i).getLastName(), entities.get(i).getEmail(), entities.get(i).getPhoneNumber());
            }
            System.out.println("-------List end-------");
        }
    }
}
