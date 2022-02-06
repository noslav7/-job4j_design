package ru.job4j.it;

import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import static java.lang.Math.E;
import static java.lang.Math.multiplyExact;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class ListUtilsTest {

    Predicate<Integer> predicate = i -> i == 2;

    @Test
    public void whenAddBefore() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addBefore(input, 1, 2);
        assertThat(input, is(Arrays.asList(1, 2, 3)));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenAddBeforeWithInvalidIndex() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addBefore(input, 3, 2);
    }

    @Test
    public void whenAddAfterLast() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 2));
        ListUtils.addAfter(input, 2, 3);
        assertThat(input, is(Arrays.asList(0, 1, 2, 3)));
    }

    @Test
    public void whenAddAfterSecond() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 2));
        ListUtils.addAfter(input, 1, 3);
        assertThat(input, is(Arrays.asList(0, 1, 3, 2)));
    }

    @Test
    public void whenRemoveIfValue() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 2));
        ListUtils.removeIf(input, predicate);
        assertThat(input, is(Arrays.asList(0, 1, 2)));
    }

    @Test
    public void whenReplaceIfValue() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4));
        ListUtils.replaceIf(input, predicate, 3);
        assertThat(input, is(Arrays.asList(0, 1, 2, 3, 4)));
    }

    @Test
    public void whenRemoveAllElements() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5));
        ListUtils.removeAll(input, new ArrayList<>(Arrays.asList(3, 5)));
        assertThat(input, is(Arrays.asList(0, 1, 2, 4)));
    }
}