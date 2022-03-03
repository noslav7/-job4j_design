package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;
import java.util.stream.Collectors;

public class LogFilter {
    public List<String> filter(String file) {
        List<String> matchList = null;
        try (BufferedReader input = new BufferedReader(new FileReader("C:\\projects\\job4j_design\\src" +
                "\\main\\java\\ru\\job4j\\io\\log.txt"))) {
                matchList = input.lines().filter(s -> s.contains("404 ")).collect(Collectors.toList());
        } catch (Exception e) {
         e.printStackTrace();
        }
        return matchList;
    }

    public static void main(String[] args) {
        LogFilter logFilter = new LogFilter();
        List<String> log = logFilter.filter("log.txt");
        System.out.println(log);
    }
}
