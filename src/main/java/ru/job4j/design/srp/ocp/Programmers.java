package ru.job4j.design.srp.ocp;

import ru.job4j.design.srp.Employee;
import ru.job4j.design.srp.Report;
import ru.job4j.design.srp.Store;

import java.util.function.Predicate;

public class Programmers implements Report {
    private Store store;

    public Programmers(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        return null;
    }
}
