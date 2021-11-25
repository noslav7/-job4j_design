package ru.job4j.generics;

public class RoleStore<T extends Base> implements Store<T> {
    private final Store<Role> store = new MemStore<>();

    @Override
    public void add(T model) {
        store.add(model);
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
