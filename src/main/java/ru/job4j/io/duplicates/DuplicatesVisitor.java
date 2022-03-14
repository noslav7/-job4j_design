package ru.job4j.io.duplicates;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DuplicatesVisitor extends SimpleFileVisitor<Path> {
    private final HashMap<FileProperty, List<Path>> names = new HashMap<>();
    private final List<FileProperty> duplicates = new ArrayList<>();

    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            FileProperty fileProperty = new FileProperty(attrs.size(), file.toFile().getName());
            if (!names.containsKey(fileProperty)) {
                List<Path> newList = new ArrayList<>();
                newList.add(file);
                names.put(fileProperty, newList);
            } else {
                names.get(fileProperty).add(file);
            }
        return FileVisitResult.CONTINUE;
    }

    public List<Path> getFiles() {
        List<Path> paths = new ArrayList<>();
        for (Map.Entry<FileProperty, List<Path>> cell : names.entrySet()) {
            List<Path> path = cell.getValue();
            if (path.size() > 1) {
                paths.addAll(path);
            }
        }
        return paths;
    }
}
