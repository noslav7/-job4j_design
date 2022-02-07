package ru.job4j.list;

public interface List<T> extends Iterable<T> {

    void add(T value);
    T set(int index, T newValue);
    T remove(int index);
    int size();
    T get(int index);
}
