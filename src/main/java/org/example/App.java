package org.example;

import org.example.interfaces.impl.ConsoleInput;
import org.example.model.Author;
import org.example.model.Book;
import org.example.model.Registry;
import org.example.model.User;
import org.example.repository.Repository;
import org.example.services.AuthorService;
import org.example.services.RegistryService;
import org.example.services.UserService;
import org.example.services.BookService;
import org.example.services.helpers.AppHelperAuthorInput;
import org.example.services.helpers.AppHelperBookInput;
import org.example.services.helpers.AppHelperRegistryInput;
import org.example.services.helpers.AppHelperUserInput;
import org.example.storages.Storage;
import org.example.interfaces.Input;

import java.util.List;

public class App {
    List<Book> books;
    List<User> users;
    List<Author> authors;
    List<Registry> registries;

    private final Input input;
    boolean repeat = true;
    int option;
    private final Repository<Book> repositoryBook;
    private final Repository<User> repositoryUser;
    private final Repository<Author> repositoryAuthor;
    private final Repository<Registry> repositoryRegistry;

    private final BookService bookService;
    private final UserService userService;
    private final RegistryService registryService;
    private final AuthorService authorService;

    private final AppHelperBookInput appHelperBookInput;
    private final AppHelperUserInput appHelperUserInput;
    private final AppHelperRegistryInput appHelperRegistryInput;
    private final AppHelperAuthorInput appHelperAuthorInput;


    public App() {
        this.input = new ConsoleInput();
        this.repositoryBook = new Storage<>("books");
        this.repositoryUser = new Storage<>("users");
        this.repositoryAuthor = new Storage<>("authors");
        this.repositoryRegistry = new Storage<>("registry");

        books = repositoryBook.load();
        users = repositoryUser.load();
        authors = repositoryAuthor.load();
        registries = repositoryRegistry.load();

        this.appHelperUserInput = new AppHelperUserInput(input, users);
        this.appHelperAuthorInput = new AppHelperAuthorInput(input, authors);
        this.appHelperBookInput = new AppHelperBookInput(input, books, appHelperAuthorInput);

        this.bookService = new BookService(books, appHelperBookInput, repositoryBook);
        this.userService = new UserService(users, appHelperUserInput, repositoryUser);
        this.authorService = new AuthorService(authors, appHelperAuthorInput, repositoryAuthor);
        this.appHelperRegistryInput = new AppHelperRegistryInput(books, users, registries, input, userService, bookService);
        this.registryService = new RegistryService(registries, repositoryRegistry, appHelperRegistryInput);
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
            System.out.println("7. Add author");
            System.out.println("8. List of authors");
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
                    if (userService.addUser()) {
                        System.out.println("User added");
                    } else {
                        System.out.println("User adding failed");
                    }
                    break;
                case 3:
                    userService.users();
                    break;
                case 4:
                    bookService.books();
                    break;
                case 5:
                    if (registryService.bookBorrow()) {
                        System.out.println("Book borrowed");
                    } else {
                        System.out.println("Book borrowing failed");
                    }
                    break;
                case 6:
                    if (registryService.returnBook()) {
                        System.out.println("Book returned");
                    } else {
                        System.out.println("Book return failed");
                    }
                    break;
                case 7:
                    if (authorService.addAuthor()) {
                        System.out.println("Authors added");
                    } else {
                        System.out.println("Authors adding failed");
                    }
                    break;
                case 8:
                    authorService.authors();
                    break;
                default:
                    System.out.println("Invalid option!");
                    break;
            }
        } while (repeat);
    }
}