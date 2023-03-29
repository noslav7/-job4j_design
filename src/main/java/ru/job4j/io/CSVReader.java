package ru.job4j.io;

import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Scanner;

public class CSVReader {
    public static void handle(ArgsName argsName) throws Exception {
        File file = File.createTempFile("file", ".csv");
        Scanner scanner = new Scanner(file).useDelimiter(",");

        while (scanner.hasNext()) {
            System.out.print(scanner.next(argsName.get("name")));
            System.out.print(" ");
            System.out.println(scanner.next(argsName.get("age")));
            scanner.nextLine();
        }

    }

    public static void main(String[] args) throws Exception {
        if (args.length != 5) {
            throw new IllegalArgumentException("Number of arguments should be 5");
        }
        ArgsName argsName = ArgsName.of(args);
        handle(argsName);
    }
}
