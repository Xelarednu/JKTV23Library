package org.example;

import org.example.model.Book;
import org.example.model.Registry;
import org.example.model.User;
import org.example.repository.BookRepos;
import org.example.repository.Repository;
import org.example.services.RegistryService;
import org.example.services.UserService;
import org.example.services.BookService;
import org.example.services.helpers.AppHelperBookInput;
import org.example.services.helpers.AppHelperRegistryInput;
import org.example.services.helpers.AppHelperUserInput;
import org.example.storages.Storage;
import org.example.interfaces.Input;

import java.util.List;

public class App {
    private final Input input;
    boolean repeat = true;
    int option;
    private final Repository<Book> repositoryBook;
    private final Repository<User> repositoryUser;
    private final Repository<Registry> repositoryRegistry;
    private final BookService bookService;
    private final UserService userService;
    private final RegistryService registryService;
    private final AppHelperUserInput appHelperUserInput;
    private final AppHelperBookInput appHelperBookInput;
    private final AppHelperRegistryInput appHelperRegistryInput;

    public App(Input input) {
        this.input = input;
        this.repositoryBook = new Storage<>("books");
        this.repositoryUser = new Storage<>("users");
        this.repositoryRegistry = new Storage<>("registry");
        this.appHelperUserInput = new AppHelperUserInput();
        this.appHelperBookInput = new AppHelperBookInput();
        this.appHelperRegistryInput = new AppHelperRegistryInput();
        this.bookService = new BookService(input, appHelperBookInput, repositoryBook);
        this.userService = new UserService(input,appHelperUserInput, repositoryUser);
        this.registryService = new RegistryService(input, repositoryRegistry, appHelperRegistryInput);
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
            System.out.println("5. Give book");
            System.out.println("6. Return book");
            System.out.print("Choose option number: ");

            option = Integer.parseInt(input.nextLine());

            switch (option) {
                case 0:
                    System.out.println("Goodbye!");
                    repeat = false;
                    break;
                case 1:
                    if(bookService.addBook()) {
                        System.out.println("Book added");
                    } else {
                        System.out.println("Book adding failed");
                    }
                    break;
                case 2:
                    if (userService.addUser()){
                        System.out.println("User added");
                    } else {
                        System.out.println("User adding failed");
                    }
                    break;
                case 3:
                    userService.users(repositoryUser);
                    break;
                case 4:
                    bookService.books(repositoryBook);
                    break;
                case 5:
                    if (registryService.bookBorrow(userService, bookService)) {
                        System.out.println("Book borrowed");
                    } else {
                        System.out.println("Book borrowing failed");
                    }
                    break;
                case 6:
                    if (registryService.returnBook(appHelperRegistryInput,bookService))
                    break;
                default:
                    System.out.println("Invalid option!");
                    break;
            }
        } while (repeat);
    }
}