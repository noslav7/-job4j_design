package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.System.out;

public class LogFilter {
    public List<String> filter(String file) {
        List<String> matchList = null;
        try (BufferedReader input = new BufferedReader(new FileReader(".\\data\\" + file))) {
                matchList = input.lines().filter(s -> s.contains(" 404 ")).collect(Collectors.toList());
        } catch (IOException e) {
         e.printStackTrace();
        }
        return matchList;
    }

    public static void save(List<String> log, String file) {
        out.printf(file + "%n", log);
    }

    public static void main(String[] args) {
        LogFilter logFilter = new LogFilter();
        List<String> log = logFilter.filter("log.txt");
        save(log, String.valueOf(log));
    }
}
