package ru.job4j.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleLinkedList<E> implements List<E> {
    private E[] container;

    private int modCount;

    private int size;

    public SimpleLinkedList(int capacity) {
        this.container = (E[]) new Object[capacity];
    }

    @Override
    public void add(E value) {
        checkSize(size);
        container[size] = value;
        size++;
        modCount++;
    }

    @Override
    public E set(int index, E newValue) {
        T element = get(index);
        container[index] = newValue;
        return element;
    }

    @Override
    public E remove(int index) {
        T element = get(index);
        System.arraycopy(container, index + 1, container, index, container.length - index - 1);
        container[size - 1] = null;
        size--;
        modCount++;
        return element;
    }

    @Override
    public E get(int index) {
        Objects.checkIndex(index, size);
        return container[index];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int elCount = 0;

            int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return elCount != size;
            }

            @Override
            public E next() {
                if (!this.hasNext()) {
                    throw new NoSuchElementException();
                }
                return container[elCount++];
            }
        };
    }
}
