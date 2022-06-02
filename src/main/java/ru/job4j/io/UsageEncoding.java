package ru.job4j.io;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UsageEncoding {
    public String readFile(String path) {
        StringBuilder builder = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(path, Charset.forName("UTF-8")))) {
            br.lines().map(s -> s + System.lineSeparator()).forEach(builder::append);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return builder.toString();
    }

    public void writeDataInFile(String path, List<String> data) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(path, Charset.forName("UTF-8"), true))) {
            data.forEach(pw::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        String path = "./src/data/text.txt";
        UsageEncoding encoding = new UsageEncoding();
        List<String> strings = new ArrayList<>(List.of(
                "Свободы сеятель пустынный",
                "Я вышел рано, до звезды",
                "Рукою чистой и безвинной в порабощенные бразды",
                "Бросал живительное семя,",
                "Но потерял я только время, благие мысли и труды..."
        ));
        encoding.writeDataInFile(path, strings);
        String s = encoding.readFile(path);

        while (!anyWordOrPhrase().equals("стоп")) {
            Collections.shuffle(strings);
            System.out.println(strings.get(0));
        }
        System.out.println("стоп");
        while (!anyWordOrPhrase().equals("продолжить")) {
            continue;
        }
        System.out.println("продолжить");
        while (!anyWordOrPhrase().equals("закончить")) {
            Collections.shuffle(strings);
            System.out.println(strings.get(0));
        }
        System.out.println("закончить");
    }

    public static String anyWordOrPhrase() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        return reader.readLine();
    }
}
