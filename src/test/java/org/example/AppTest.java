package org.example;
import org.example.model.Author;
import org.example.model.Book;
import org.example.model.User;
import org.example.repository.BookRepos;
import org.example.repository.UserRepos;
import org.example.services.BookService;
import org.example.services.helpers.AppHelperBookDataInput;
import org.example.services.helpers.AppHelperUserDataInput;
import org.example.storages.StorageBook;
import org.example.storages.StorageUser;
import org.example.tools.Input;
import org.example.tools.impl.ConsoleInput;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

class AppTest {

    Input inputMock;
    BookRepos bookReposMock;
    PrintStream defaultOut;
    ByteArrayOutputStream mockOut;
    UserRepos userReposMock;

    @BeforeEach
    void setUp() {
        inputMock = Mockito.mock(ConsoleInput.class);
        bookReposMock = Mockito.mock(StorageBook.class);
        userReposMock = Mockito.mock(StorageUser.class);
        defaultOut = System.out;
        mockOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(mockOut));
    }

    @AfterEach
    void tearDown() {
        System.setOut(defaultOut);
    }

    @Test
    void appRunExit() {
        when(inputMock.nextLine()).thenReturn("0");
        App app = new App(inputMock, bookReposMock);
        app.run();
        String expectedOutput = "Goodbye!";
        String actualOutput = mockOut.toString();

       // Just for check
//        System.setOut(defaultOut);
//        System.out.println(actualOutput);

        assertTrue(actualOutput.contains(expectedOutput));
    }

    @Test
    void appAddBook() {
        when(inputMock.nextLine()).thenReturn("1", "0");
        AppHelperBookDataInput appHelperBookDataInputMock = Mockito.mock(AppHelperBookDataInput.class);
        BookService bookServiceMock = Mockito.mock(BookService.class);
        Author author = new Author("Robert", "Chambers");
        List<Author> authors = new ArrayList<>();
        authors.add(author);
        Book book =  new Book("The King in Yellow", authors, 1895);
        when(appHelperBookDataInputMock.createBook(inputMock)).thenReturn(book);
        App app = new App(inputMock, bookReposMock);
        app.run();
        String expectedOutput = "Book added";
        String actualOutput = mockOut.toString();
       assertTrue(actualOutput.contains(expectedOutput));
    }

    @Test
    void runAddUser () {
        when(inputMock.nextLine()).thenReturn("2", "0");
        AppHelperUserDataInput appHelperUserDataInputMock = Mockito.mock(AppHelperUserDataInput.class);
        User user = new User("Ivan", "Ivanov", "4589657142", "1va4ov@gmail.com");
        when(appHelperUserDataInputMock.createUser(inputMock)).thenReturn(user);
        App app = new App(inputMock, bookReposMock);
        app.run();
        String expectedOutput = "User added";
        String actualOutput = mockOut.toString();
        assertTrue(actualOutput.contains(expectedOutput));
    }
}