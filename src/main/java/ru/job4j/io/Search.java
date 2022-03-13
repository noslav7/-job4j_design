package ru.job4j.io;

import java.io.IOException;
import java.nio.file.*;
import java.util.List;
import java.util.function.Predicate;

public class Search {
    public static void main(String[] args) throws IOException {
        if (args.length == 2) {
            throw new IllegalArgumentException("Root folder or extension is null. Usage of files .txt");
        }
        Path start = Paths.get(".");
        if (!start.toFile().exists() && !start.toFile().isDirectory()) {
            throw new InvalidPathException(start.toFile().getAbsolutePath(), "Such directory or file does not exist");
        }
        search(start, p -> p.toFile().getName().endsWith(".txt")).forEach(System.out::println);
    }

    public static List<Path> search(Path root, Predicate<Path> condition) throws IOException {
        SearchFiles searcher = new SearchFiles(condition);
        Files.walkFileTree(root, searcher);
        return searcher.getPaths();
    }
}
