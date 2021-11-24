package ru.job4j.generics;

public class RoleStore<T extends Base> implements Store<Role> {
    private final Store<Role> store = new RoleStore<>();

    @Override
    public void add(Role model) {

    }

    @Override
    public boolean replace(String id, Role model) {
        return false;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public Role findById(String id) {
        return null;
    }
}
