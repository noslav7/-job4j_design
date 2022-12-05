package ru.job4j.io;

import ru.job4j.io.ArgsName;

import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringJoiner;

public class CSVReader {
    public static void handle(ArgsName argsName) throws Exception {
        Path path = Path.of("file.csv");
        try (Scanner scanner = new Scanner(path).useDelimiter("; ")) {
            while (scanner.hasNext()) {
                String arg = scanner.next();
                if (arg.equals(argsName.get("name"))) {
                    System.out.print(arg);
                    System.out.print(",");
                } else if (arg.equals(argsName.get("age"))) {
                    System.out.print(arg);
                    System.out.println(",");
                }
            }
        }
    }
}
