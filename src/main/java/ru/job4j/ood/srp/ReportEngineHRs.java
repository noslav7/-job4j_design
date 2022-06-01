package ru.job4j.ood.srp;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class ReportEngineHRs implements Report {

    private Store store;

    public ReportEngineHRs(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Salary;");
        List<Employee> employees = store.findBy(filter);
        employees.sort(Comparator.comparingDouble(Employee::getSalary).reversed());
        for (Employee employee : employees) {
                text.append(System.lineSeparator())
                    .append(employee.getName()).append(";")
                    .append(employee.getSalary()).append(";");
        }
        return text.toString();
    }
}
