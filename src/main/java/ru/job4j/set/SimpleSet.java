package ru.job4j.set;

import ru.job4j.list.SimpleArrayList;

import java.util.Iterator;

public class SimpleSet<T> implements Set<T> {
    private SimpleArrayList<T> set = new SimpleArrayList<>();

    @Override
    public boolean add(T value) {
        boolean add = true;
        if (contains(value)) {
            add = false;
        }
        return add;
    }

    @Override
    public boolean contains(T value) {
        boolean contains = false;
        for (T cell : set) {
            if (cell.equals(value)) {
                contains = true;
            }
        }
        return contains;
    }

    @Override
    public Iterator<T> iterator() {
        return set.iterator();
    }
}
