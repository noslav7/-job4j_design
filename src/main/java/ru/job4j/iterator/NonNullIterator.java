package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class NonNullIterator implements Iterator<Integer> {
    private Integer[] data;
    private int index;

    public NonNullIterator(Integer[] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        boolean nextFalse = false;
        for (int i = index + 1; i <= data.length; i++) {
            if (data[i] != null) {
                return true;
            }
        }
        return nextFalse;
    }

    @Override
    public Integer next() {
        if (data[++index] != null) {
            return data[index];
        } else {
            throw new NoSuchElementException();
        }
    }
}
