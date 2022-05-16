package ru.job4j.kiss;

import java.util.Comparator;

public class IntMaxComparator implements Comparator<Integer> {

    @Override
    public int compare(Integer o1, Integer o2) {
        return o1 > o2 ? o1 : o2;
    }
}
