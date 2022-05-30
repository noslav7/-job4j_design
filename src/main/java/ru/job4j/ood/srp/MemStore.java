package ru.job4j.ood.srp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MemStore implements Store, HRStore {
    private final List<Employee> employees = new ArrayList<>();

    public void add(Employee em) {
        employees.add(em);
    }

    @Override
    public List<Employee> findBy(Predicate<Employee> filter) {
        return employees.stream().filter(filter).collect(Collectors.toList());
    }

    @Override
    public List<Employee> findByHR(Predicate<Employee> filter) {
        return employees.stream().filter(filter).sorted(Comparator.reverseOrder()).collect(Collectors.toList());
    }
}
