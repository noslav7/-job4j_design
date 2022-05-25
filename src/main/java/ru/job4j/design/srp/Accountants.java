package ru.job4j.design.srp;

import java.util.function.Predicate;

public class Accountants implements Report {
    private Store store;

    public Accountants(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        return null;
    }
}
