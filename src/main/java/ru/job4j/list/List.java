package ru.job4j.list;

public interface List<T> extends Iterable<T> {

    boolean contains(T element);
    int indexOf(T element);
    int lastIndexOf(T element);
    int size();
    List<T> subList(int fromIndex, int toIndex);
}
