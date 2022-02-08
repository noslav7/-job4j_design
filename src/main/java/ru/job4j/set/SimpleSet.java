package ru.job4j.set;

import ru.job4j.list.SimpleArrayList;

import java.util.Iterator;
import java.util.Objects;

public class SimpleSet<T> implements Set<T> {
    private SimpleArrayList<T> set = new SimpleArrayList<>(0);

    @Override
    public boolean add(T value) {
        boolean add = !contains(value);
        if (add) {
            set.add(value);
        }
        return add;
    }

    @Override
    public boolean contains(T value) {
        boolean contains = false;
        for (T cell : set) {
            if (Objects.equals(cell, value)) {
                contains = true;
                break;
            }
        }
        return contains;
    }

    @Override
    public Iterator<T> iterator() {
        return set.iterator();
    }
}
