package ru.job4j.io;

import org.hamcrest.Matchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.*;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class ConfigTest {

    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Test
    public void whenPairWithoutComment() {
        String path = "./data/app.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("name "), is(" Petr Arsentev"));
        assertThat(config.value("surname"), is(Matchers.nullValue()));
    }

    @Test
    public void whenPairWithEmptyStrings() {
        String path = "./data/pair_with_comments.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("text"), is("the file with the comment and empty strings"));
    }

    @Test (expected = IllegalArgumentException.class)
    public void whenDoesntConformTemplate() {
        String path = "./data/template_violation.properties";
        Config config = new Config(path);
        config.load();
    }

 /*   @Test
    public void load() throws IOException {
        File source = folder.newFile(".\\data\\source.txt");
        File target = folder.newFile(".\\data\\target.txt");
        try (PrintWriter out = new PrintWriter(source)) {
            out.println("quite small text");
            out.println("java javarush job4j");
        }
        Config config = new Config(".\\data\\source.txt");
        config.load(source.getAbsolutePath(), target.getAbsolutePath(), List.of("foolish", "php"));
        StringBuilder rsl = new StringBuilder();
        try (BufferedReader in = new BufferedReader(new FileReader(target))) {
            in.lines().forEach(rsl::append);
        }
        assertThat(rsl.toString(), is("hello dude java job4j "));
    }*/
}