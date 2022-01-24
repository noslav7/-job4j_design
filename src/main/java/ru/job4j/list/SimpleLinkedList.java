package ru.job4j.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;


public class SimpleLinkedList<E> implements List<E> {
    private Node<E> node;

    private int modCount;

    private int size;

    private static class Node<E> {
        private E item;

        private Node<E> next;

        public Node(E item, Node<E> next) {
            this.item = item;
            this.next = next;
        }
    }

    @Override
    public void add(E value) {
        Node<E> newNode = new Node<>(value, null);
        size++;
        modCount++;
    }

    @Override
    public E get(int index) {
        E cell = null;
        for (int i = 0; i < size - 1; i++) {
            if (i == index) {
                cell = node.item;
            }
        }
        return cell;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int elCount = 0;

            final int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                boolean hasNext = false;
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                if (node.next != null) {
                    hasNext = true;
                }
                return hasNext;
            }

            @Override
            public E next() {
                if (!this.hasNext()) {
                    throw new NoSuchElementException();
                }
                elCount++;
                return node.item;
            }
        };
    }
}
