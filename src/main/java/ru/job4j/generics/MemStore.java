package ru.job4j.generics;

import java.util.HashMap;
import java.util.Map;

public class MemStore<T extends Base> implements Store<T> {
    private final Map<String, T> mem = new HashMap<>();

    @Override
    public void add(T model) {
        mem.put(model.toString(), model);
    }

    @Override
    public boolean replace(String id, T model) {
        if (mem.containsKey(id)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(String id) {
        if (mem.containsKey(id)) {
            return true;
        }
        return false;
    }

    @Override
    public T findById(String id) {
        if (mem.containsKey(id)) {
            return mem.get(id);
        }
        return null;
    }
}
