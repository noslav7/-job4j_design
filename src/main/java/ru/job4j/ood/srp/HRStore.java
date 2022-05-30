package ru.job4j.ood.srp;

import java.util.List;
import java.util.function.Predicate;

public interface HRStore {

    List<Employee> findByHR(Predicate<Employee> filter);
}
