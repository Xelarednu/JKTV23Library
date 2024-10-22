//package org.example.services.helpers;
//
//import org.example.model.Author;
//import org.example.model.Book;
//import org.example.interfaces.Input;
//import org.example.interfaces.impl.ConsoleInput;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mockito;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.when;
//
//class AppHelperBookDataInputTest {
//
//    Input inputMock;
//    AppHelperBookInput appHelperBookDataInput = new AppHelperBookInput();
//
//    @BeforeEach
//    void setUp() {
//        inputMock = Mockito.mock(ConsoleInput.class);
//    }
//
//    @AfterEach
//    void tearDown() {
//        inputMock = null;
//    }
//
//    @Test
//    void appHelperBookDataInputCreateBook() {
//        when(inputMock.nextLine()).thenReturn("The King in Yellow", "1", "Robert", "Chambers", "1895");
//        Book actual = appHelperBookDataInput.createBook(inputMock);
//        Author author = new Author("Robert", "Chambers");
//        List<Author> authors = new ArrayList<>();
//        authors.add(author);
//        Book expected = new Book ("The King in Yellow", authors, 1895);
//        assertTrue(actual.getTitle().equals(expected.getTitle()));
//    }
//}