package ru.job4j.kiss;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.*;

public class MaxMinTest {

    @Test
    public void whenIntegersMax() {
        MaxMin maxMin = new MaxMin();
        Comparator<Integer> comparator = Comparator.naturalOrder();
        List<Integer> listInt = new ArrayList<>(List.of(1, 7, 10, 5, 3));
        int max = maxMin.max(listInt, comparator);
        int expected = 10;
        assertEquals(expected, max);
    }

    @Test
    public void whenStringLengthMax() {
        MaxMin maxMin = new MaxMin();
        Comparator<Integer> comparator = Comparator.naturalOrder();
        List<Integer> listInt = new ArrayList<>(List.of(1, 7, 10, 5, 3));
        int max = maxMin.max(listInt, comparator);
        int expected = 10;
        assertEquals(expected, max);
    }
}