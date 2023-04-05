package ru.job4j.io;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CSVReader {
    public static void handle(ArgsName argsName) throws Exception {

        List<String> data = new ArrayList<>();
        Scanner scanner1 = new Scanner(argsName.get("path"));
        while (scanner1.hasNext()) {
            data.add(scanner1.next());
        }

        List<String> filter = new ArrayList<>();
        Scanner scanner2 = new Scanner(argsName.get("filter")).useDelimiter(";");
        while (scanner2.hasNext()) {
            filter.add(scanner2.next());
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
