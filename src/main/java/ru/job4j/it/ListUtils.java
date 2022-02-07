package ru.job4j.it;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ListUtils {

    public static <T> void addBefore(List<T> list, int index, T value) {
        Objects.checkIndex(index, list.size());
        ListIterator<T> iterator = list.listIterator(index);
                 iterator.add(value);
                 iterator.next();
    }

    public static <T> void addAfter(List<T> list, int index, T value) {
        Objects.checkIndex(index, list.size());
        if (index == list.size() - 1) {
            list.add(value);
        } else {
            ListIterator<T> iterator = list.listIterator(index + 1);
                    iterator.add(value);
                    iterator.next();
        }
    }

    public static <T> void removeIf(List<T> list, Predicate<T> filter) {
        List<T> result = list.stream()
                .filter(filter)
                .toList();
    }

    public static <T> void replaceIf(List<T> list, Predicate<T> filter, T value) {
        List<T> result = list.stream()
                .filter(filter)
                .map(item -> value)
                .toList();
    }

    public static <T> void removeAll(List<T> list, List<T> elements) {
        ListIterator<T> iterator = list.listIterator();
        while (iterator.hasNext()) {
            if (elements.contains(iterator.next())) {
                iterator.remove();
            }
        }
    }
}
