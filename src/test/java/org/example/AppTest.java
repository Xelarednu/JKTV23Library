package org.example;
import org.example.repository.BookRepos;
import org.example.storages.StorageBook;
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

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

class AppTest {

    Input inputMock;
    BookRepos bookReposMock;
    PrintStream defaultOut;
    ByteArrayOutputStream mockOut;

    @BeforeEach
    void setUp() {
        inputMock = Mockito.mock(ConsoleInput.class);
        bookReposMock = Mockito.mock(StorageBook.class);
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

        //Just for check
//        System.setOut(defaultOut);
//        System.out.println(actualOutput);

        assertTrue(actualOutput.contains(expectedOutput));
    }

    @Test
    void appAddBook() {

//        assertTrue();
//        assertTrue(actualOutput.contains(expectedOutput));
    }
}