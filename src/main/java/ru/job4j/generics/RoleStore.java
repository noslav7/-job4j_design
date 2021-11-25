package ru.job4j.generics;

public class RoleStore<T extends Base> implements Store<T> {
    private final Store<Role> store = new MemStore<>();

    @Override
    public void add(T model) {
        store.add((Role) model);
    }

    @Override
    public boolean replace(String id, T model) {
        if (store.replace(id, (Role) model)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(String id) {
        if (store.delete(id)) {
            return true;
        }
        return false;
    }

    @Override
    public T findById(String id) {
        return (T) store.findById(id);
    }
}
