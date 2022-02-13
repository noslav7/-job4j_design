package ru.job4j.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FreezeStr {
    public static boolean eq(String left, String right) {
        boolean equal = true;
        if (left.length() != right.length()) {
            equal = false;
            return equal;
        }
        List<Character> first = left.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
        List<Character> second = right.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
        List<Character> list = new ArrayList<>(first);
        for(int i = 0; i < second.size(); i++) {
            if (!list.contains(second.get(i))) {
                equal = false;
                break;
            }
            list.remove(second.get(i));
        }
        return equal;
    }
}
