package ru.job4j.it;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenNumbersIterator  implements Iterator<Integer> {

    private int[] data;
    private int index;

    public EvenNumbersIterator(int[] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        return data[index] % 2 == 0;
    }

    @Override
    public Integer next() {
        if (hasNext()) {
            return data[index];
        } else {
            throw new NoSuchElementException();
        }
    }
}
