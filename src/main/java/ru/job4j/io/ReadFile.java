package ru.job4j.io;

import java.io.FileInputStream;

public class ReadFile {
    public static void main(String[] args) {
        try (FileInputStream in = new FileInputStream("C:\\projects\\job4j_design" +
                "\\src\\main\\java\\ru\\job4j\\input.txt")) {
            StringBuilder text = new StringBuilder();
            int read;
            while ((read = in.read()) != -1) {
                text.append((char) read);
            }
            System.out.println(text);
            String[] lines = text.toString().split(System.lineSeparator());
            for (String line : lines) {
                System.out.println(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
