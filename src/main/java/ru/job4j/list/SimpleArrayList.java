package ru.job4j.list;

import java.util.*;

public class SimpleArrayList<T> implements List<T> {
    private T[] container;

    private int size;

    private int modCount;

    public SimpleArrayList() {
    }

    public T set(int index, T newValue) {
        T element = get(index);
        container[index] = newValue;
        return element;
    }

    public T remove(int index) {
        T element = get(index);
        System.arraycopy(container, index + 1, container, index, container.length - index - 1);
        container[size - 1] = null;
        size--;
        modCount++;
        return element;
    }

    @Override
    public boolean contains(T element) {
        boolean contains = false;
        for (T cell : container) {
            if (cell.equals(element)) {
                contains = true;
                break;
            }
        }
        return contains;
    }

    @Override
    public int indexOf(T element) {
        int index = 0;
        for (int i = 0; i < container.length; i++) {
            if (container[i].equals(element)) {
                index = i;
                break;
            }
        }
        return index;
    }

    @Override
    public int lastIndexOf(T element) {
        int index = 0;
        for (int i = container.length - 1; i > -1; i--) {
            if (container[i].equals(element)) {
                index = i;
                break;
            }
        }
        return index;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
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
            public T next() {
                if (!this.hasNext()) {
                    throw new NoSuchElementException();
                }
                return container[elCount++];
            }
        };
    }

        public void checkSize(int size) {
        if (size + 1 > container.length && container.length == 0) {
            container = Arrays.copyOf(container, 1);
        } else if (size + 1 > container.length && container.length != 0) {
                container = Arrays.copyOf(container, container.length * 2);
            }
        }
    }
