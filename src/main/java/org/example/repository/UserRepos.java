package org.example.repository;

import org.example.model.User;

import java.util.List;

public interface UserRepos {
    void saveUser(User user);

    List<User> loadUser();
}
