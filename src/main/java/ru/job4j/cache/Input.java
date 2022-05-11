package ru.job4j.cache;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Input extends AbstractCache<String, String> {
    String phrase = """
            Лишь тот способен добрым быть,
            Кому пришлось от злости выть.
            Лишь тот узнает дружбы цену,
            Кто испытал друзей измену.
            И лишь тому любовь дана,
            Кто ненависть познал сполна.""";
    @Override
    protected String load(String text) {
        try (FileWriter writer = new FileWriter(text)) {
            writer.write(phrase);
        } catch (IOException ioe) {
            throw new RuntimeException(ioe);
        }
        return phrase;
    }
}
