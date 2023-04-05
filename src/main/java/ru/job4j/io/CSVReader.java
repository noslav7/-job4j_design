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

        Scanner scanner2 = new Scanner(argsName.get("filter"));
        String[] filter = scanner2.nextLine().split(";");

        List<String> headers = new ArrayList<>();
        Scanner scanner3 = new Scanner(data.get(0)).useDelimiter(";");
        while (scanner3.hasNext()) {
            headers.add(scanner3.next());
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
