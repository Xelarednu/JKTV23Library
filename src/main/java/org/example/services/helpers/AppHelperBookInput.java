package org.example.services.helpers;

import org.example.model.Author;
import org.example.model.Book;
import org.example.interfaces.Input;

import java.util.Arrays;
import java.util.List;

public class AppHelperBookInput {

    public Book createBook(Input input) {
        try {
            Book book = new Book();
            System.out.println("========= New book =========");
            System.out.println("Book name: ");
            book.setTitle(input.nextLine());
            System.out.println("Book authors: ");
            System.out.print("Authors amount: ");
            int countAuthors = Integer.parseInt(input.nextLine());

            for (int i = 0; i < countAuthors; i++) {
                Author author = new Author();
                System.out.printf("Author %d:%n", i + 1);
                System.out.println("Author first name: ");
                author.setFirstName(input.nextLine());
                System.out.println("Author last name: ");
                author.setLastName(input.nextLine());
                book.getAuthor().add(author);
            }

            System.out.println("Book publish year: ");
            book.setPublishYear(Integer.parseInt(input.nextLine()));
            return book;
        } catch (Exception e) {
            System.out.println("Error: " + e);
            return null;
        }
    }

    public void printBooks(List<Book> books) {
        if (books.isEmpty()) {
            System.out.println("Book list is empty");
        } else {
            System.out.println("-------Book list-------");
            for (int i = 0; i < books.size(); i++) {
                System.out.printf("%d %s %n %s %n %d %n", i + 1, books.get(i).getTitle(), Arrays.toString(books.get(i).getAuthor().toArray()), books.get(i).getPublishYear());
            }
            System.out.println("-------List end-------");
        }
    }
}
