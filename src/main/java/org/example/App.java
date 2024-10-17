package org.example;

import org.example.model.Book;
import org.example.model.User;
import org.example.repository.BookRepos;
import org.example.repository.Repository;
import org.example.services.UserService;
import org.example.services.BookService;
import org.example.services.helpers.AppHelperBookDataInput;
import org.example.services.helpers.AppHelperUserDataInput;
import org.example.storages.Storage;
import org.example.tools.Input;

import java.util.List;

public class App {
    private final Input input;
    boolean repeat = true;
    int option;
    public static List<Book> books;
    private BookRepos bookRepos;
    Repository<Book> repositoryBook;
    Repository<User> repositoryUser;
    private BookService bookService;
    private UserService userService;
    private AppHelperUserDataInput appHelperUserDataInput;
    private AppHelperBookDataInput appHelperBookDataInput;

    public App(Input input) {
        this.input = input;
        this.repositoryBook = new Storage<>("books");
        this.repositoryUser = new Storage<>("users");
        this.bookRepos = bookRepos;
        this.bookService = new BookService(input, repositoryBook);
        this.userService = new UserService(input, repositoryUser);
        this.appHelperUserDataInput = new AppHelperUserDataInput();
        this.appHelperBookDataInput = new AppHelperBookDataInput();

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
                    if(bookService.addBook(appHelperBookDataInput)) {
                        System.out.println("Book added");
                    }
                    break;
                case 2:
                    if (userService.addUser(appHelperUserDataInput)){
                        System.out.println("User added");
                    }
                    break;
                case 4:
                    bookService.books(appHelperBookDataInput, repositoryBook);
                    break;
                default:
                    System.out.println("Invalid option!");
                    break;
            }
        } while (repeat);
    }
}