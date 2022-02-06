package ru.job4j.set;

import ru.job4j.list.SimpleArrayList;

import java.util.Iterator;

public class SimpleSet<T> implements Set<T> {
    private SimpleArrayList<T> set = new SimpleArrayList<>();

    @Override
    public boolean add(T value) {
        boolean add = true;
        while (iterator().hasNext()) {
            if (iterator().next().equals(value)) {
                add = false;
                break;
            }
        }
        return add;
    }

    @Override
    public boolean contains(T value) {
        boolean contains = false;
        while (iterator().hasNext()) {
            if (iterator().next().equals(value)) {
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
