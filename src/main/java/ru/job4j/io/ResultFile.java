package ru.job4j.io;

import java.io.FileOutputStream;
import java.util.Arrays;

public class ResultFile {
   public static void main(String[] args) {
        try (FileOutputStream out = new FileOutputStream("С:\\Users\\Рачков\\IdeaProjects"
                + "\\job4j_elementary\\test\\ru\\job4j\\array\\MatrixTest.java")) {
                out.write("1, 2, 3, 4, 5, 2, 4, 6, 8, 10, 3, 6, 9, 12, 15, 4, 8, 12, 16, 20, 5, 10, 15, 20, 25".getBytes());
                out.write(System.lineSeparator().getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
