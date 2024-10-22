package org.example.services.helpers;

import org.example.interfaces.Input;
import org.example.model.Author;
import org.example.model.Book;

import java.util.List;

public class AppHelperAuthorInput {

    private final Input input;
    private final List<Author> authors;

    public AppHelperAuthorInput(Input input, List<Author> authors) {
        this.input = input;
        this.authors = authors;
    }

    public List<Author> createAuthor() {
        try {
            Book book = new Book();
            System.out.println("========= New Authors =========");

            System.out.println("Book authors: ");
            System.out.print("Enter authors amount: ");
            int countAuthors = Integer.parseInt(input.nextLine());

            for (int i = 0; i < countAuthors; i++) {
                Author author = new Author();
                System.out.printf("Author %d:%n", i + 1);
                System.out.println("Author first name: ");
                author.setFirstName(input.nextLine());
                System.out.println("Author last name: ");
                author.setLastName(input.nextLine());
                //Tried to make adding author to the book. Somehow need to return book to AppHelperBookInput.
                book.getAuthor().add(author);
                //---------------------------------------
                authors.add(author);
            }

            return authors;
        } catch (Exception e) {
            System.out.println("Error: " + e);
            return null;
        }
    }

    public void printAuthors() {
        if (authors.isEmpty()) {
            System.out.println("Authors list is empty");
        } else {
            System.out.println("-------Author list-------");
            for (int i = 0; i < authors.size(); i++) {
                System.out.printf("%d %s %s %n", i + 1, authors.get(i).getFirstName(), authors.get(i).getLastName());
            }
            System.out.println("-------List end-------");
        }
    }
}