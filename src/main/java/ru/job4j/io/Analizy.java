package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Analizy {
    public void unavailable(String source, String target) throws IOException {
        boolean online = true;
        List<String> strings = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(source));
             PrintWriter out = new PrintWriter(new BufferedOutputStream(new FileOutputStream(target)))) {
             strings = in.lines()
                    .flatMap(line -> Stream.of(line.split("\\s+")))
                    .toList();
        }
        for (int i = 0; i < strings.size(); i = i + 2) {
            if (strings.get(i).equals("200") || strings.get(i).equals("300")) {
                if (!online) {
                    System.out.println(strings.get(i + 1));
                    online = true;
                }
            } else if (strings.get(i).equals("400") || strings.get(i).equals("500")) {
                if (online) {
                    System.out.println(strings.get(i + 1) + ";");
                    online = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        try (PrintWriter out = new PrintWriter(new FileOutputStream("unavailable.csv"))) {
            out.println("15:01:30;15:02:32");
            out.println("15:10:30;23:12:32");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
