package ru.job4j.map;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleMap<K, V> implements Map<K, V> {
    private static final float LOAD_FACTOR = 0.75f;
    private int capacity = 8;

    private int count = 0;

    private int modCount = 0;

    private MapEntry<K, V>[] table = new MapEntry[capacity];

    @Override
    public boolean put(K key, V value) {
        if (count >= capacity * LOAD_FACTOR) {
            expand();
        }
        int index;
        boolean put = false;
        index = indexFor(hash(key.hashCode()));
        if (table[index] == null) {
            put = true;
            table[index] = new MapEntry<>(key, value);
            modCount++;
            count++;
        }
        return put;
    }

    private int hash(int hashCode) {
        int result = (hashCode == 0) ? 0 : hashCode ^ (hashCode >>> 16);
        return result;
    }

    private int indexFor(int hash) {
        return (table.length - 1) & hash;
    }

    private void expand() {
        capacity = capacity * 2;
        MapEntry<K, V>[] newTable = new MapEntry[capacity];
        for (int i = 0; i < table.length; i++) {
            if (table[i] != null) {
                K key = table[i].key;
                newTable[indexFor(hash(key.hashCode()))] = table[i];
            }
        }
        table = newTable;
    }

    @Override
    public V get(K key) {
        int index = indexFor(hash(key.hashCode()));
        V value = null;
        if (Objects.equals(table[index].key, key)) {
            value = table[index].value;
        }
        return value;
    }

    @Override
    public boolean remove(K key) {
        boolean removed = false;
        int index = indexFor(hash(key.hashCode()));
        if (Objects.equals(table[index].key, key)) {
            removed = true;
            table[index].value = null;
            modCount--;
        }
        return removed;
    }

    @Override
    public Iterator<K> iterator() {

        return new Iterator<K>() {
            int index = modCount;

            @Override
            public boolean hasNext() {
                if (index != modCount) {
                    throw new ConcurrentModificationException();
                }
                while (index < table.length && table[index] == null) {
                    index++;
                }
                return index < table.length && table[index] != null;
            }

            @Override
            public K next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return table[index++].key;
            }
        };
    }

    static class MapEntry<K, V> {

        K key;
        V value;

        public MapEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
