package ru.job4j.kiss;

import java.util.*;

public class MaxMin {

    public <T> T max(List<T> value, Comparator<T> comparator) {
        return maxValue(value, comparator);
    }

    public <T> T min(List<T> value, Comparator<T> comparator) {
        return maxValue(value, comparator.reversed());
    }

    public <T> T maxValue(List<T> value, Comparator<T> comparator) {
        T result = value.get(0);
        for (int i = 0; i < value.size() - 1; i++) {
            if (comparator.compare(value.get(i), value.get(i + 1)) > 0) {
                result = value.get(i);
            }
        }
        if (comparator.compare(result, value.get(value.size() - 1)) < 0) {
            result = value.get(value.size() - 1);
        }
        return result;
    }
}
