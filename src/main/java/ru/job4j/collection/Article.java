package ru.job4j.collection;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Article {
    public static boolean generateBy(String origin, String line) {
        String[] wordStart = origin.replace(".", " ")
                .replace("!", " ").replace(",", " ").split(" ");
        List<String> start = Arrays.stream(wordStart).collect(Collectors.toList());
        String[] wordEnd = line.split(" ");
        List<String> end = Arrays.stream(wordEnd).collect(Collectors.toList());
        HashSet<String> set = new HashSet<String>(start);
        boolean isOriginal = true;
        for (int i = 0; i < end.size(); i++) {
              if (!set.contains(end.get(i))) {
                    isOriginal = false;
                    break;
                }
            }
        return isOriginal;
    }
}
