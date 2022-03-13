package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Analizy {
    public static void unavailable(String source, String target) {
        boolean online = true;
        List<String> strings = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(source));
             PrintWriter out = new PrintWriter(new BufferedOutputStream(new FileOutputStream(target)))) {
            strings = in.lines()
                    .flatMap(line -> Stream.of(line.split("\\s+")))
                    .toList();
            for (int i = 0; i < strings.size(); i = i + 2) {
                if ("200".equals(strings.get(i)) || "300".equals(strings.get(i))) {
                    if (!online) {
                        out.write(strings.get(i + 1) + System.lineSeparator());
                        online = true;
                    }
                } else if ("400".equals(strings.get(i)) || "500".equals(strings.get(i))) {
                    if (online) {
                        out.write(strings.get(i + 1) + ";");
                        online = false;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Analizy.unavailable(".\\data\\unavailable.csv", ".\\data\\target.txt");
    }
}
