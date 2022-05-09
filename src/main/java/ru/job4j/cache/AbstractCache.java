package ru.job4j.cache;

import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractCache<K, V> {
    protected final Map<K, SoftReference<V>> cache = new HashMap<>();

    public void put(K key, V value) {
        SoftReference<V> vValue = new SoftReference<>(value);
        cache.put(key, vValue);
    }

    public V get(K key) {
        SoftReference<V> vObj = cache.get(key);
        return vObj.get();
    }

    protected abstract V load(K key);
}
