package ru.job4j.ood.srp;

import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.function.Predicate;

public class ReportEngineHRs implements Report {

    private Store store;

    public ReportEngineHRs(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Salary;");
        for (Employee employee : store.findBy(filter)) {
                text.append(System.lineSeparator())
                    .append(employee.getName()).append(";")
                    .append(employee.getSalary()).append(";");
        }
        return text.toString();
    }
}
