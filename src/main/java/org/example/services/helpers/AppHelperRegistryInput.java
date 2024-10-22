package org.example.services.helpers;

import org.example.interfaces.Input;
import org.example.model.Book;
import org.example.model.Registry;
import org.example.model.User;
import org.example.services.BookService;
import org.example.services.UserService;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class AppHelperRegistryInput {

    private final BookService bookService;
    private final List<Book> books;
    private final List<User> users;
    private final List<Registry> registries;
    private final Input input;
    private final UserService userService;

    public AppHelperRegistryInput(List<Book> books, List<User> users, List<Registry> registries, Input input, UserService userService, BookService bookService) {
        this.books = books;
        this.users = users;
        this.registries = registries;
        this.input = input;
        this.userService = userService;
        this.bookService = bookService;
    }

    public Registry bookBorrow() {
        try {
            Registry registry = new Registry();
            userService.users();
            System.out.print("Enter user number from list: ");
            int userNumber = Integer.parseInt(input.nextLine());
            User user = users.get(userNumber - 1);

            bookService.books();
            System.out.print("Enter book number from list: ");
            int bookNumber = Integer.parseInt(input.nextLine());
            Book book = books.get(bookNumber - 1);

            registry.setUser(user);
            registry.setBook(book);
            registry.setBookBorrowDate(LocalDate.now());

            return registry;
        } catch (Exception e) {
            return null;
        }
    }

    public void printListBorrowedBooks() {
        if (registries.isEmpty()) {
            System.out.println("Borrowed books list is empty");
        } else {
            System.out.println("-------Borrowed books list-------");
            for (int i = 0; i < registries.size(); i++) {
                if ((registries.get(i)).getReturnBookDate() != null) {
                    continue;
                }
                System.out.printf("%s %n %s %n %s", i + 1, registries.get(i).getBook().getTitle(), Arrays.toString(registries.get(i).getBook().getAuthor().toArray()), registries.get(i).getBook().getPublishYear());
            }
            System.out.println("-------List end-------");
        }
    }

    public boolean returnBookDialog() {
        try {
            printListBorrowedBooks();
            System.out.println("Enter returnable book number from list: ");
            int numberReturnBook = Integer.parseInt(input.nextLine());
            registries.get(numberReturnBook - 1).setReturnBookDate(LocalDate.now());
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}