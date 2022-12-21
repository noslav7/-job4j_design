package ru.job4j.io;

public class CSVReader {
    public static void handle(ArgsName argsName) throws Exception {
        int numOfArgs = argsName.toString().split(",").length;
        if (numOfArgs == 0 || numOfArgs > 5) {
            throw new IllegalArgumentException("There should be from one to five arguments");
        }


    }
}
