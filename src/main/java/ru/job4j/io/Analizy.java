package ru.job4j.io;

import java.io.*;
import java.util.stream.Stream;

public class Analizy {
    /* public void unavailable(String source, String target) throws IOException {
        try (BufferedReader in = new BufferedReader(new FileReader(source));
             PrintWriter out = new PrintWriter(new BufferedOutputStream(new FileOutputStream(target)))) {
            in.lines()
                    .flatMap(line -> Stream.of(line.split("/d00")))
                    .filter(n -> !n.startsWith()).map(word -> word + " ")
                    .forEach(target::print);
        }
    }

    public static void main(String[] args) {
        try (PrintWriter out = new PrintWriter(new FileOutputStream("unavailable.csv"))) {
            out.println("15:01:30;15:02:32");
            out.println("15:10:30;23:12:32");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/
}
