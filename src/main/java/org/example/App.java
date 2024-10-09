package org.example;

import org.example.model.Book;
import org.example.repository.BookRepos;
import org.example.services.BookService;
import org.example.services.helpers.BookDataInput;
import org.example.storages.StorageBook;

import java.util.List;
import java.util.Scanner;

public class App {
    private Scanner scanner = new Scanner(System.in);
    boolean repeat = true;
    int option;
    public static List<Book> books;
    private BookRepos bookRepos = new StorageBook();

    public App() {
        this.books = bookRepos.loadBooks();
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

            option = Integer.parseInt(scanner.nextLine());

            switch (option) {
                case 0:
                    System.out.println("Goodbye!");
                    repeat = false;
                    break;
                case 1:
                    BookService bookService = new BookService(scanner);
                    bookService.addBook(new BookDataInput());
                    break;
                default:
                    System.out.println("Invalid option!");
                    break;
            }
        } while (repeat);
    }
}