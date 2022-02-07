package ru.job4j.collection.list;

import org.hamcrest.core.Is;
import org.junit.Test;
import ru.job4j.list.List;

import java.util.Iterator;

import static org.junit.Assert.*;

public class SimpleLinkedListTest {
    @Test
    public void add() {
        ru.job4j.list.List<Integer> list = new SimpleLinkedList<>();
        list.add(100);
        list.add(1000);
        list.add(-100);
        list.add(0);
        assertThat(list.get(0), Is.is(100));
        assertThat(list.get(1), Is.is(1000));
        assertThat(list.get(2), Is.is(-100));
        assertThat(list.get(3), Is.is(0));
    }

    @Test
    public void get() {
        ru.job4j.list.List<String> list = new SimpleLinkedList<>();
        list.add("2_000_000");
        list.add("second");
        list.add("third");
        assertThat(list.get(0), Is.is("2_000_000"));
        assertThat(list.get(1), Is.is("second"));
        assertThat(list.get(2), Is.is("third"));
    }

    @Test
    public void whenAddAndGet() {
        ru.job4j.list.List<Integer> list = new SimpleLinkedList<>();
        list.add(1);
        list.add(2);
        assertThat(list.get(0), Is.is(1));
        assertThat(list.get(1), Is.is(2));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenGetFromOutOfBoundThenExceptionThrown() {
        ru.job4j.list.List<Integer> list = new SimpleLinkedList<>();
        list.add(1);
        list.add(2);
        list.get(2);
    }

    @Test
    public void whenAddIterHasNextTrue() {
        ru.job4j.list.List<Integer> list = new SimpleLinkedList<>();
        list.add(1);
        Iterator<Integer> it = list.iterator();
        assertThat(it.hasNext(), Is.is(true));
    }

    @Test
    public void whenAddIterNextOne() {
        ru.job4j.list.List<Integer> list = new SimpleLinkedList<>();
        list.add(1);
        Iterator<Integer> it = list.iterator();
        assertThat(it.next(), Is.is(1));
    }

    @Test
    public void whenEmptyIterHashNextFalse() {
        ru.job4j.list.List<Integer> list = new SimpleLinkedList<>();
        Iterator<Integer> it = list.iterator();
        assertThat(it.hasNext(), Is.is(false));
    }

    @Test
    public void whenAddIterMultiHasNextTrue() {
        ru.job4j.list.List<Integer> list = new SimpleLinkedList<>();
        list.add(1);
        Iterator<Integer> it = list.iterator();
        assertThat(it.hasNext(), Is.is(true));
        assertThat(it.hasNext(), Is.is(true));
    }

    @Test
    public void whenAddIterNextOneNextTwo() {
        ru.job4j.list.List<Integer> list = new SimpleLinkedList<>();
        list.add(1);
        list.add(2);
        Iterator<Integer> it = list.iterator();
        assertThat(it.next(), Is.is(1));
        assertThat(it.next(), Is.is(2));
    }

    @Test
    public void whenGetIteratorTwiceThenEveryFromBegin() {
        List<Integer> list = new SimpleLinkedList<>();
        list.add(1);
        list.add(2);
        Iterator<Integer> first = list.iterator();
        assertThat(first.hasNext(), Is.is(true));
        assertThat(first.next(), Is.is(1));
        assertThat(first.hasNext(), Is.is(true));
        assertThat(first.next(), Is.is(2));
        assertThat(first.hasNext(), Is.is(false));
        Iterator<Integer> second = list.iterator();
        assertThat(second.hasNext(), Is.is(true));
        assertThat(second.next(), Is.is(1));
        assertThat(second.hasNext(), Is.is(true));
        assertThat(second.next(), Is.is(2));
        assertThat(second.hasNext(), Is.is(false));
    }
}