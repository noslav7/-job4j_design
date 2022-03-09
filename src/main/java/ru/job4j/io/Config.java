package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Config {
    private final String path;
    private final Map<String, String> values = new HashMap<String, String>();

    public Config(final String path) {
        this.path = path;
    }

    public void load() {
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            String line;
            String[] splitted = new String[0];
            while ((line = read.readLine() )!= null) {
                splitted = line.split("=");                
            };
            Iterator<String> iterator = Arrays.stream(splitted).iterator();
            while (iterator.hasNext()) {
                values.put(iterator.next(), iterator.next());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String value(String key) {
        throw new UnsupportedOperationException("Don't implement this method yet!");
    }

    @Override
    public String toString() {
        StringJoiner out = new StringJoiner(System.lineSeparator());
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            read.lines().forEach(out::add);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return out.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Config("./data/pair_without_comment.properties"));
    }
}
