package ru.job4j.io;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

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

    public static void save(List<String> log, String file) throws FileNotFoundException {
        try (PrintStream out = new PrintStream(new FileOutputStream(file))) {
            for (String s : log) {
                out.print(s);
            }
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        LogFilter logFilter = new LogFilter();
        List<String> log = logFilter.filter("log.txt");
        save(log, "log.txt");
    }
}
