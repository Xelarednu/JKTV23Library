package org.example.services.helpers;

import org.example.interfaces.Input;
import org.example.model.Book;
import org.example.model.Registry;
import org.example.model.User;
import org.example.repository.Repository;
import org.example.services.BookService;
import org.example.services.UserService;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class AppHelperRegistryInput {

    public Registry bookBorrow(Input input, UserService userService, BookService bookService) {
        try {
            Registry registry = new Registry();
            userService.users(userService.getRepository());
            System.out.print("Enter user number from list: ");
            int userNumber = Integer.parseInt(input.nextLine());
            User user = userService.getRepository().getEntities().get(userNumber - 1);

            bookService.books(bookService.getRepository());
            System.out.print("Enter book number from list: ");
            int bookNumber = Integer.parseInt(input.nextLine());
            Book book = bookService.getRepository().getEntities().get(bookNumber - 1);

            registry.setUser(user);
            registry.setBook(book);
            registry.setBookBorrowDate(LocalDate.now());

            return registry;
        } catch (Exception e) {
            return null;
        }
    }

    public void listBorrowedBooks(Repository repository) {
        List<Registry> registryList = (List<Registry>) repository.getEntities();
        if (repository.getEntities().isEmpty()) {
            System.out.println("Borrowed books list is empty");
        } else {
            System.out.println("-------Borrowed books list-------");
            for (int i = 0; i < repository.getEntities().size(); i++) {
                if ((registryList.get(i)).getReturnBookDate() != null) {
                    continue;
                }
                System.out.printf("%s %n %s %n %s", i + 1, registryList.get(i).getBook().getTitle(), Arrays.toString(registryList.get(i).getBook().getAuthor().toArray()), registryList.get(i).getBook().getPublishYear());
            }
            System.out.println("-------List end-------");
        }
    }

    public boolean returnBookDialog(Input input, Repository repository) {
        try {
            listBorrowedBooks(repository);
            System.out.println("Enter returnable book number from list: ");
            int numberReturnBook = Integer.parseInt(input.nextLine());
            Registry registry = (Registry) repository.getEntities().get(numberReturnBook - 1);
            registry.setReturnBookDate(LocalDate.now());

            return true;
        } catch (Exception e) {
            return false;
        }
    }
}