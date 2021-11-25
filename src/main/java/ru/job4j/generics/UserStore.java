package ru.job4j.generics;

public class UserStore<T extends Base> implements Store<T> {
    private final Store<User> store = new MemStore<>();

    @Override
    public void add(T model) {
        store.add((User) model);
    }

    @Override
    public boolean replace(String id, T model) {
        if (store.replace(id, (User) model)) {
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
