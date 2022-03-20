package ru.job4j.io;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ArgsName {

    private final Map<String, String> values = new HashMap<>();

    public String get(String key) {
        if (!values.containsKey(key)) {
            throw new IllegalArgumentException();
        }
        return values.get(key);
    }

    private void parse(String[] args) throws IOException {
        for (String arg : args) {
           if (!validate(arg)) {
               throw new IllegalArgumentException();
           }
        }
    }

    public static ArgsName of(String[] args) throws IOException {
        ArgsName names = new ArgsName();
        names.parse(args);
        return names;
    }

    public static void main(String[] args) throws IOException {
        if (args.length == 0) {
            throw new IOException("No arguments");
        }
        ArgsName jvm = ArgsName.of(new String[]{"-Xmx=512", "-encoding=UTF-8"});
        System.out.println(jvm.get("Xmx"));

        ArgsName zip = ArgsName.of(new String[]{"-out=project.zip", "-encoding=UTF-8"});
        System.out.println(zip.get("out"));
    }

    private static boolean validate(String arg) throws IOException {
        boolean valid = false;
            if (arg.startsWith("-") && arg.contains("=")
                    && !arg.startsWith("-=") && !arg.endsWith("=")) {
                valid = true;
            }
        return valid;
    }
}
