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
        return checkIfEven();
    }

    @Override
    public Integer next() {
        if (checkIfEven()) {
            return data[index++];
        } else {
            index++;
        }
        return next();
    }

    public static boolean checkIfEven() {
        return index > -1 && index < data.length && data[index] % 2 == 0;
    }
}
