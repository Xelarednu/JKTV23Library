package org.example.services.helpers;

import org.example.model.User;
import org.example.tools.Input;


public class AppHelperUserDataInput {

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
}
