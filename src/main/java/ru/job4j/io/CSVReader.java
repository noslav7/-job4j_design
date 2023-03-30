package ru.job4j.io;

import java.io.File;
import java.nio.file.Files;
import java.util.Scanner;

public class CSVReader {
    public static void handle(ArgsName argsName) throws Exception {
        File file = File.createTempFile("file", ".csv");
        Files.writeString(file.toPath(), argsName.get("-filter"));

        Scanner scanner = new Scanner(file).useDelimiter(";");

        while (scanner.hasNext()) {
            System.out.println(scanner.next(argsName.get("-filter")));
            scanner.nextLine();
        }
    }

    public static void main(String[] args) throws Exception {
        if (args.length != 4) {
            throw new IllegalArgumentException("There should be 4 arguments");
        }
        ArgsName argsName = ArgsName.of(args);
        handle(argsName);
    }
}
