package ru.job4j.iterator;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class CyclicIterator<T> implements Iterator<T>{

    private List<T> data;
    int index = 0;

    public CyclicIterator(List<T> data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        boolean hasNext = false;
        if (index + 1 < data.size() && !data.isEmpty()) {
            hasNext = true;
        } else if (index + 1 == data.size() && !data.isEmpty()) {
            index = 0;
            hasNext = true;
        }
        return hasNext;
    }

    @Override
    public T next() {
        T element = null;
        if (index + 1 < data.size()) {
            element = data.get(index);
            index++;
        } else if (index + 1 == data.size()) {
            element = data.get(data.size() - 1);
            index = 0;
        }
        if (element != null) {
            return element;
        } else {
            throw new NoSuchElementException();
        }
    }
}
