package ru.job4j.io;

import ru.job4j.io.ArgsName;

import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringJoiner;

public class CSVReader {
    public static void handle(ArgsName argsName) throws Exception {
        File file = File.createTempFile("source.csv", ",");
        try (BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(file))) {
            out.write(argsName.get(-filter=name));
            out.write(argsName.get(-filter=age));
        }
        try (var scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                System.out.print(scanner.next());
                System.out.print(",");
            }
        }

    }
}
