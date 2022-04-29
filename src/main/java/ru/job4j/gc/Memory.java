package ru.job4j.gc;

public class Memory {

    public static void main(String[] args) {
        for (int i = 0; i < 106_500; i++) {
            new User(10, "Squirrel");
            new User();
            User user = new User(100, "Bear");
        }
    }
}
