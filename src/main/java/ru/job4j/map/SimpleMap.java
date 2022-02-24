package ru.job4j.map;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleMap<K, V> implements Map<K, V> {
    private static final float LOAD_FACTOR = 0.75f;
    private int capacity = 8;

    private int count = 0;

    private int modCount = 0;

    private MapEntry<K, V>[] table = new MapEntry[capacity];

    @Override
    public boolean put(K key, V value) {
        if (table.length >= capacity * LOAD_FACTOR) {
            expand();
        }
        int index;
        boolean put = false;
        index = indexFor(hash(hashCode()));
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
        if (modCount >= LOAD_FACTOR * capacity) {
            capacity = (int) (capacity * 1.5 + 1);
            MapEntry<K, V>[] newTable = new MapEntry[capacity];
            for (int i = 0; i < table.length; i++) {
                K key = table[i].key;
                newTable[indexFor((Integer) key)] = table[i];
            }
        }
    }

    @Override
    public V get(K key) {
        int index = indexFor(hash(hashCode()));
        V value = table[index].value;
        return key == table[index].key ? value : null;
    }

    @Override
    public boolean remove(K key) {
        boolean removed = false;
        if (get(key) == table[count]) {
            removed = true;
            modCount--;
        }
        return removed;
    }

    @Override
    public Iterator<K> iterator() {
        count = modCount;

        return new Iterator<K>() {
            @Override
            public boolean hasNext() {
                while (count < table.length && count % 2 == 1) {
                    count++;
                }
                return count < table.length && count % 2 == 0;
            }

            @Override
            public K next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return table[count++].key;
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
