package ru.job4j.it;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenNumbersIterator  implements Iterator<Integer> {

    private static int[] data;
    private static int index;

    public EvenNumbersIterator(int[] data) {
        EvenNumbersIterator.data = data;
    }

    @Override
    public boolean hasNext() {
        while (index > -1 && index < data.length && data[index] % 2 == 1) {
            index++;
        }
        return index > -1 && index < data.length && data[index] % 2 == 0;
    }

    @Override
    public Integer next() {
        if (index < 0 || index >= data.length) {
            throw new NoSuchElementException();
        }
        return data[index++];
    }
}
