package ru.job4j.map;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleMap<K, V> implements Map<K, V>{
    private static final float LOAD_FACTOR = 0.75f;

    private int capacity = 8;

    private int count = 0;

    private int modCount = 0;

    private MapEntry<K, V>[] table = new MapEntry[capacity];

    @Override
    public boolean put(K key, V value) {
        boolean put = false;
        if (modCount < 8) {
            put = true;
            modCount++;
        }
        return put;
    }

    private int hash(int hashCode) {
        int h = 0;
        return (hashCode == 0) ? 0 : (h = hashCode) ^ (h >>> 16);
    }

    private int indexFor(int hash) {
        return (table.length - 1) & hash;
    }

    private void expand() {
        capacity = (int) (capacity * 1.5 + 1);
    }

    @Override
    public V get(K key) {
        return key == null ? null : get(key);
    }

    @Override
    public boolean remove(K key) {
        boolean removed = false;
        if (remove(key)) {
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
                if (count != modCount) {
                    throw new ConcurrentModificationException();
                }
                return count != table.length;
            }

            @Override
            public K next() {
                if (!this.hasNext()) {
                    throw new NoSuchElementException();
                }
                return (K) table[count++];
            }
        };
    }

    private static class MapEntry<K, V> {

        K key;
        V value;

        public MapEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
