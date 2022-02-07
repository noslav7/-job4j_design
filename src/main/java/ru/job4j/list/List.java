package ru.job4j.list;

public interface List<E> extends Iterable<E> {
    void add(E value);
    E get(int index);
    boolean contains(E element);
    int indexOf(E element);
    int lastIndexOf(E element);
    int size();
    List<E> subList(int fromIndex, int toIndex);
}
