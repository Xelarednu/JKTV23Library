package org.example;

import org.example.interfaces.Input;
import org.example.interfaces.impl.ConsoleInput;

public class Main {
    public static void main(String[] args) {

        Input input = new ConsoleInput();

        App app = new App(input);
        app.run();
    }
}