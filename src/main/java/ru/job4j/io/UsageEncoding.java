package ru.job4j.io;

import javax.imageio.IIOException;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
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

    public void writeDataInFile(String path, String data) {
        try (PrintWriter pw = new PrintWriter(
                new FileWriter(path, Charset.forName("UTF-8"), true))) {
            pw.println(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String path = "./src/data/text.txt";
        UsageEncoding encoding = new UsageEncoding();
        List<String> strings = List.of(
                "Новая строка 1",
                "Новая строка 2",
                "Новая строка 3",
                "Новая строка 4",
                "Новая строка 5"
        );
        for (String str : strings) {
            encoding.writeDataInFile(path, str);
        }
        String s = encoding.readFile(path);
        System.out.println("Данные из файла: ");
        System.out.println(s);
    }
}
