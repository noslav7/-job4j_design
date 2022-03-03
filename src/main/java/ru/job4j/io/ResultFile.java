package ru.job4j.io;

import java.io.FileOutputStream;

public class ResultFile {
   public static void main(String[] args) {
        try (FileOutputStream out = new FileOutputStream("С:\\Users\\Рачков\\IdeaProjects"
                + "\\job4j_design\\main\\java\\ru\\job4j\\ResultFile.txt")) {
                out.write(("1, 2, 3, 4, 5, " +
                          "2, 4, 6, 8, 10, " +
                          "3, 6, 9, 12, 15, " +
                          "4, 8, 12, 16, 20, " +
                          "5, 10, 15, 20, 25").getBytes());
                out.write(System.lineSeparator().getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
