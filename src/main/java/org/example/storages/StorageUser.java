package org.example.storages;

import org.example.model.User;
import org.example.repository.UserRepos;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StorageUser implements UserRepos{

    private List<User> users;
    private final String fileName = "users";

    public StorageUser() {

    }

    @Override
    public void saveUser(User user) {
        FileOutputStream fileOutputStream;
        ObjectOutputStream objectOutputStream;
        try {
            fileOutputStream = new FileOutputStream(fileName);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(users);
            objectOutputStream.flush();
            users.add(user);
        } catch (FileNotFoundException e) {
            System.out.println("There is no such file: " + e);
        } catch (IOException e) {
            System.out.println("I/O error: " + e);
        }
    }

    @Override
    public List<User> loadUser() {
        FileInputStream fileInputStream;
        ObjectInputStream objectInputStream;
        try {
            fileInputStream = new FileInputStream(fileName);
            objectInputStream = new ObjectInputStream(fileInputStream);
            return (List<User>) objectInputStream.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("There is no such file: " + e);
        } catch (IOException e) {
            System.out.println("I/O error: " + e);
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found: " + e);
        }
        return new ArrayList<>();
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public String getFileName() {
        return fileName;
    }
}
