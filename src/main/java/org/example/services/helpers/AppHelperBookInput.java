package org.example.services.helpers;

import org.example.model.Book;
import org.example.interfaces.Input;

import java.util.Arrays;
import java.util.List;

public class AppHelperBookInput {
    private final Input input;
    private final List<Book> books;
    private final AppHelperAuthorInput appHelperAuthorInput;

    public AppHelperBookInput(Input input, List<Book> books, AppHelperAuthorInput appHelperAuthorInput) {
        this.input = input;
        this.books = books;
        this.appHelperAuthorInput = appHelperAuthorInput;
    }

    public Book createBook() {
        try {
            Book book = new Book();
            System.out.println("========= New book =========");
            System.out.println("Book name: ");
            book.setTitle(input.nextLine());

            appHelperAuthorInput.createAuthor();

            System.out.println("Book publish year: ");
            book.setPublishYear(Integer.parseInt(input.nextLine()));
            return book;
        } catch (Exception e) {
            System.out.println("Error: " + e);
            return null;
        }
    }

    public void printBooks() {
        if (books.isEmpty()) {
            System.out.println("Book list is empty");
        } else {
            System.out.println("-------Book list-------");
            for (int i = 0; i < books.size(); i++) {

                for (int k = 0; k < books.get(i).getAuthor().size(); k++) {
                    System.out.println(k);
                }

                System.out.printf("%d %s %s %d %n", i + 1, books.get(i).getTitle(), Arrays.toString(books.get(i).getAuthor().toArray()), books.get(i).getPublishYear());
            }
            System.out.println("-------List end-------");
        }
    }
}