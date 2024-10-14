package org.example.storages;

import org.example.model.Book;
import org.example.repository.BookRepos;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StorageBook implements BookRepos {

    public static List<Book> books;
    private final String fileName = "books";

    public StorageBook() {

    }

    @Override
    public void saveBook(Book book) {
        FileOutputStream fileOutputStream;
        ObjectOutputStream objectOutputStream;
        try {
            fileOutputStream = new FileOutputStream(fileName);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(books);
            objectOutputStream.flush();
            books.add(book);
        } catch (FileNotFoundException e) {
            System.out.println("There is no such file: " + e);
        } catch (IOException e) {
            System.out.println("I/O error: " + e);
        }
    }

    @Override
    public List<Book> loadBooks() {
        FileInputStream fileInputStream;
        ObjectInputStream objectInputStream;
        try {
            fileInputStream = new FileInputStream(fileName);
            objectInputStream = new ObjectInputStream(fileInputStream);
            return (List<Book>) objectInputStream.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("There is no such file: " + e);
        } catch (IOException e) {
            System.out.println("I/O error: " + e);
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found: " + e);
        }
        return new ArrayList<>();
    }
}