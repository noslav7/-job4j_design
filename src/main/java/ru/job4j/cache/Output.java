package ru.job4j.cache;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Output extends AbstractCache<String, String> {

    @Override
    protected String load(String source) {
        try {
            return Files.readString(Paths.get(source));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
