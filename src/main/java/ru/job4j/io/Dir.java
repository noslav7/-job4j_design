package ru.job4j.io;

import java.io.File;

public class Dir {
    public static void main(String[] args) {
        File file = new File(".\\data\\dirFile.txt");
        if (!file.exists()) {
            throw new IllegalArgumentException(String.format("Not exist %s", file.getAbsoluteFile()));
        }
        if (file.isDirectory()) {
            System.out.println(0);
            return;
        }
        System.out.println(String.format("size : %s", file.length()));
    }
}
