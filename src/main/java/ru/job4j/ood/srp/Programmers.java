package ru.job4j.ood.srp;

import ru.job4j.ood.srp.Employee;
import ru.job4j.ood.srp.Report;
import ru.job4j.ood.srp.Store;

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
