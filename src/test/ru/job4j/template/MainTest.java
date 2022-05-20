package ru.job4j.template;

import org.junit.Ignore;
import org.junit.Test;

import java.util.HashMap;
import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;

public class  MainTest {

    @Ignore
    @Test(expected = IllegalArgumentException.class)
    public void whenMapContainsNoSuchKeys() {
        Main main = new Main();
        String template = "I am a ${name}. Who are ${subject}";
        HashMap<String, String> map = new HashMap<String, String>();
        map.put(null, null);
        String result = main.produce(template, map);
    }

    @Ignore
    @Test(expected = IllegalArgumentException.class)
    public void whenMapAlsoContainsOtherKeys() {
        Main main = new Main();
        String template = "I am a ${name}. Who are ${subject}";
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("Petr Arsentev", "you");
        map.put("Andrei Khynku", "they");
        String result = main.produce(template, map);
    }

    @Ignore
    @Test
    public void whenGenerationSuccessful() {
        Main main = new Main();
        String template = "I am a ${name}. Who are ${subject}";
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("Petr Arsentev", "you");
        String result = main.produce(template, map);
        String expected = "I am a Petr Arsentev. Who are you";
        assertEquals(expected, result);
    }
}