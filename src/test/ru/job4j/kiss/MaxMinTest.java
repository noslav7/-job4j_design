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
    public void whenStringsMax() {
        MaxMin maxMin = new MaxMin();
        Comparator<String> comparator = Comparator.naturalOrder();
        List<String> listString = new ArrayList<>(List.of("England", "Andorra", "Denmark", "China", "Belgium"));
        String country = maxMin.max(listString, comparator);
        String expected = "England";
        assertEquals(expected, country);
    }

    @Test
    public void whenIntegersMin() {
        MaxMin maxMin = new MaxMin();
        Comparator<Integer> comparator = Comparator.naturalOrder();
        List<Integer> listInt = new ArrayList<>(List.of(1, 7, 10, 5, 3));
        int min = maxMin.min(listInt, comparator);
        int expected = 1;
        assertEquals(expected, min);
    }

    @Test
    public void whenStringsMin() {
        MaxMin maxMin = new MaxMin();
        Comparator<String> comparator = Comparator.naturalOrder();
        List<String> listString = new ArrayList<>(List.of("England", "Andorra", "Denmark", "China", "Belgium"));
        String country = maxMin.min(listString, comparator);
        String expected = "Andorra";
        assertEquals(expected, country);
    }
}