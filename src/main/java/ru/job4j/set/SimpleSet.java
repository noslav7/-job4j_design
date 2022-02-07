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
        } else {
            set.add(value);
        }
        return add;
    }

    @Override
    public boolean contains(T value) {
        boolean contains = false;
        for (int i = 0; i < set.size(); i++) {
            if (set.get(i).equals(value)) {
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
