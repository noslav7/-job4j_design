package ru.job4j.it;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Optional;

public class MatrixIt implements Iterator<Integer> {
private final int[][] data;
private int row = 0;
private int column = 0;

public MatrixIt(int[][] data) {
        this.data = data;
        }

@Override
public boolean hasNext() {
        boolean hasN = false;
        for (int[] datum : data) {
                for (int i : datum) {
                        if (datum == null || data == null) {
                                hasN = true;
                        }
                }
        }
        return hasN;
}

@Override
public Integer next() {
        if (!hasNext()) {
        throw new NoSuchElementException();
        }
        return null;
        }
}
