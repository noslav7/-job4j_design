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

    private void parse(String[] args) {
        if (args.length == 0) {
            throw new IllegalArgumentException("args is empty");
        }
        for (String arg : args) {
            if (!validate(arg)) {
                throw new IllegalArgumentException();
            }
            String[] splittedArg = arg.split("=", 2);
            StringBuilder sb = new StringBuilder(splittedArg[0]);
            values.put(String.valueOf(sb.deleteCharAt(0)), splittedArg[1]);
        }
    }

    public static ArgsName of(String[] args) {
        ArgsName names = new ArgsName();
        names.parse(args);
        return names;
    }

    public static void main(String[] args) throws IOException {

        ArgsName jvm = ArgsName.of(new String[]{"-Xmx=512", "-encoding=UTF-8"});
        System.out.println(jvm.get("Xmx"));

        ArgsName zip = ArgsName.of(new String[]{"-out=project.zip", "-encoding=UTF-8"});
        System.out.println(zip.get("out"));
    }

    public static boolean validate(String arg) {
        boolean valid = false;
        char[] charArg = arg.toCharArray();
        int count = 0;
        for (int i = 0; i < charArg.length; i++) {
            if (charArg[i] == '=') {
                count++;
            }
        }
        if (arg.startsWith("-") && arg.contains("=")
                && !arg.startsWith("-=") && !(arg.endsWith("=") && (count == 1))) {
            valid = true;
        }
        return valid;
    }
}
