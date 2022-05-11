package ru.job4j.cache;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DirFileCache extends AbstractCache<String, String> {

    private final String cachingDir;

    public DirFileCache(String cachingDir) {
        this.cachingDir = cachingDir;
    }

    @Override
    protected String load(String cachingDir) {
        try {
            return Files.readString(Paths.get(cachingDir));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
