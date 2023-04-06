package ru.job4j.io;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CSVReader {
    public static void handle(ArgsName argsName) throws Exception {

        List<String> data = new ArrayList<>();
        Scanner scanner1 = new Scanner(new File(argsName.get("path")));
        while (scanner1.hasNext()) {
            data.add(scanner1.next());
        }

        Scanner scanner2 = new Scanner(argsName.get("filter"));
        String[] filter = scanner2.nextLine().split(";");

        List<String> headersList = new ArrayList<>();
        Scanner scanner3 = new Scanner(data.get(0)).useDelimiter(";");
        while (scanner3.hasNext()) {
            headersList.add(scanner3.next());
        }

        List<String> matchList = new ArrayList<>();
        for (int i = 0; i < headersList.size(); i++) {
            for (int j = 0; j < filter.length; j++) {
                if (headersList.get(i).equals(filter[j])) {
                    matchList.add(filter[j]);
                }
            }
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
