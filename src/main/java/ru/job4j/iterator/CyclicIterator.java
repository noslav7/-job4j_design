package ru.job4j.iterator;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class CyclicIterator<T> implements Iterator<T> {

    private final List<T> data;
    int index;

    public CyclicIterator(List<T> data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        return index <= data.size() && !data.isEmpty();
    }

    @Override
    public T next() {
        T element = null;
        if (index == data.size() && !data.isEmpty()) {
            element = data.get(0);
            index = 0;
        }
        if (index < data.size() && !data.isEmpty()) {
            element = data.get(index);
            index++;
        }
        if (element != null) {
            return element;
        } else {
            throw new NoSuchElementException();
        }
    }
}
