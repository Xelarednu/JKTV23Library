package org.example.services.helpers;

import org.example.model.Author;
import org.example.model.Book;

import java.util.Scanner;

public class BookDataInput {

    public Book createBook(Scanner scanner) {
        Book book = new Book();
        System.out.println("========= New book =========");
        System.out.println("Book name: ");
        book.setTitle(scanner.nextLine());
        System.out.println("Book authors: ");
        System.out.print("Authors amount: ");
        int countAuthors = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < countAuthors; i++) {
            Author author = new Author();
            System.out.printf("Author %d:%n", i + 1);
            System.out.println("Author first name: ");
            author.setFirstName(scanner.nextLine());
            System.out.println("Author last name: ");
            author.setLastName(scanner.nextLine());
            book.getAuthor().add(author);
        }
        System.out.println("Book publish year: ");
        book.setPublishYear(scanner.nextInt());
        return book;
    }

}
