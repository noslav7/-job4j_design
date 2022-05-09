package ru.job4j.cache;

import java.io.*;

public class DirFileCache extends AbstractCache<String, String> {

    private final String cachingDir;

    public DirFileCache(String cachingDir) {
        this.cachingDir = cachingDir;
    }

    @Override
    protected String load(String key) {
        File file = new File(key);
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String currentLine = reader.readLine();
            reader.close();
            return currentLine;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
