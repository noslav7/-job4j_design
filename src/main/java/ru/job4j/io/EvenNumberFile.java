package ru.job4j.io;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

public class EvenNumberFile {

    public static void main(String[] args) {
        try (FileInputStream input = new FileInputStream("С:\\Users\\Рачков\\IdeaProjects"
                + "\\job4j_design\\src\\main\\java\\ru\\job4j\\even.txt")) {
                List<Integer> numbers = new ArrayList<>();
                int read;
                while ((read = input.read()) != -1) {
                if (read % 2 == 0) {
                    numbers.add(read);
                }
            }
            System.out.println(numbers);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
