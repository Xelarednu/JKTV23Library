package org.example;

import org.example.model.Book;
import org.example.repository.BookRepos;
import org.example.services.BookService;
import org.example.services.UserService;
import org.example.services.helpers.AppHelperBookDataInput;
import org.example.services.helpers.AppHelperUserDataInput;
import org.example.storages.StorageBook;
import org.example.tools.Input;

import java.util.List;
import java.util.Scanner;

public class App {
    private final Input input;
    private Scanner scanner = new Scanner(System.in);
    boolean repeat = true;
    int option;
    public static List<Book> books;
    private BookRepos bookRepos;

    public App(Input input, BookRepos bookRepos) {
        this.input = input;
        this.bookRepos = bookRepos;
    }

    public void run() {
        System.out.println("----------- JKTV23 library -----------");

        do {
            System.out.println("Option list: ");
            System.out.println("0. Quit program");
            System.out.println("1. Add book");
            System.out.println("2. Add reader");
            System.out.println("3. List of readers");
            System.out.println("4. List of books");
            System.out.println("5. Take book");
            System.out.println("6. Return book");
            System.out.print("Choose option number: ");

            option = Integer.parseInt(input.nextLine());

            switch (option) {
                case 0:
                    System.out.println("Goodbye!");
                    repeat = false;
                    break;
                case 1:
                    BookService bookService = new BookService(input, bookRepos);
                    bookService.addBook(new AppHelperBookDataInput());
                    break;
//                case 2:
//                    UserService userService = new UserService(input);
//                    userService.addUser(new AppHelperUserDataInput());
//                    break;
                default:
                    System.out.println("Invalid option!");
                    break;
            }
        } while (repeat);
    }
}