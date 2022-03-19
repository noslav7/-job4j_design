package ru.job4j.io;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ArgsName {

    private final Map<String, String> values = new HashMap<>();

    public String get(String key) {
        for (String clue : values.keySet()) {
            if (!values.containsKey(clue)) {
                throw new IllegalArgumentException();
            }
        }
        return values.get(key);
    }

    private void parse(String[] args) throws IOException {
          if (validate(args)) {
              String[] splittedArgs1 = args[0].split("=", 2);
              String[] splittedArgs2 = args[1].split("=", 2);
              values.put(splittedArgs1[0], splittedArgs1[1]);
              values.put(splittedArgs2[0], splittedArgs2[1]);
        }
    }

    public static ArgsName of(String[] args) throws IOException {
        ArgsName names = new ArgsName();
        names.parse(args);
        return names;
    }

    public static void main(String[] args) throws IOException {

        ArgsName jvm = ArgsName.of(new String[] {"-Xmx=512", "-encoding=UTF-8"});
        System.out.println(jvm.get("Xmx"));

        ArgsName zip = ArgsName.of(new String[] {"-out=project.zip", "-encoding=UTF-8"});
        System.out.println(zip.get("out"));
    }

    private boolean validate(String[] args) throws IOException {
        boolean valid = false;
        if (args.length == 0) {
            throw new IOException("No arguments");
        }
        for (String arg : args) {
            if (arg.startsWith("-") && arg.contains("=")
                    && !arg.startsWith("-=") && !arg.endsWith("=")) {
                valid = true;
            } else {
                valid = false;
                break;
            }
        }
        return valid;
    }
}
