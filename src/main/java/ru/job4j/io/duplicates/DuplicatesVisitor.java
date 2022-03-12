package ru.job4j.io.duplicates;

import ru.job4j.map.Map;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DuplicatesVisitor extends SimpleFileVisitor<Path> {
    private final HashMap<FileProperty, Path> names = new HashMap<>();
    private final List<FileProperty> duplicates = new ArrayList<>();

    public FileVisitResult visitFile(List<Path> file, BasicFileAttributes attrs) throws IOException {
        for (int i = 0; i < file.size(); i++) {
            FileProperty fileProperty = new FileProperty(attrs.size(), file.get(i).toFile().getName());
            if (!names.containsKey(fileProperty)) {
                duplicates.add(fileProperty);
            } else {
                names.put(fileProperty, file.get(i));
            }
        }
        return FileVisitResult.CONTINUE;
    }

    public List<FileProperty> getFiles() {
        return duplicates;
    }
}
