package org.example.services.helpers;

import org.example.model.User;
import org.example.interfaces.Input;

import java.util.List;


public class AppHelperUserInput {

    private final List<User> users;
    private final Input input;

    public AppHelperUserInput(Input input, List<User> users) {
        this.input = input;
        this.users = users;
    }

    public User createUser () {
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

    public void printUsers() {
        if (users.isEmpty()) {
            System.out.println("Users list is empty");
        } else {
            System.out.println("-------Readers list-------");
            for (int i = 0; i < users.size(); i++) {
                System.out.printf("%d %s %s %s %s %n", i + 1, users.get(i).getFirstName(), users.get(i).getLastName(), users.get(i).getEmail(), users.get(i).getPhoneNumber());
            }
            System.out.println("-------List end-------");
        }
    }
}
