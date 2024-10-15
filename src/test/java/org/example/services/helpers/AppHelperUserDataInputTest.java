package org.example.services.helpers;

import org.example.model.Author;
import org.example.model.Book;
import org.example.model.User;
import org.example.tools.Input;
import org.example.tools.impl.ConsoleInput;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class AppHelperUserDataInputTest {

    Input inputMock;
    AppHelperUserDataInput appHelperUserDataInput = new AppHelperUserDataInput();

    @BeforeEach
    void setUp() {
        inputMock = Mockito.mock(ConsoleInput.class);
    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void createUser() {
        when(inputMock.nextLine()).thenReturn("Ivan", "Ivanov", "4589657142", "1va4ov@gmail.com");
        User actual = appHelperUserDataInput.createUser(inputMock);
        User expected = new User("Ivan", "Ivanov", "4589657142", "1va4ov@gmail.com");
        assertEquals(actual.getFirstName(), expected.getFirstName());
        assertEquals(actual.getLastName(), expected.getLastName());
    }
}