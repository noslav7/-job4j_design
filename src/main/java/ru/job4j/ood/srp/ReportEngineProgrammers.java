package ru.job4j.ood.srp;

import java.util.function.Predicate;

public class ReportEngineProgrammers implements Report {

    private Store store;

    public ReportEngineProgrammers(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
                text.append("<!DOCTYPE HTML")
                    .append(System.lineSeparator())
                    .append("<html>").append(System.lineSeparator())
                    .append("<head>").append(System.lineSeparator())
                    .append("meta http-equiv=\"Content Type\" content=\"text/html; charset=UTF-8")
                    .append(System.lineSeparator())
                    .append("<title>Таблица</title>").append(System.lineSeparator())
                    .append("</head>").append(System.lineSeparator())
                    .append("<body>").append(System.lineSeparator())
                    .append("<table>").append(System.lineSeparator())
                    .append("<tr>").append(System.lineSeparator())
                    .append("<th>Name</th><th>Hired</th><th>Fired</th><th>Salary</th>")
                    .append(System.lineSeparator());
        for (Employee emplyee : store.findBy(filter)) {
                text.append("<tr>").append(emplyee.getName()).append("</td")
                    .append("<tr>").append(emplyee.getHired()).append("</td")
                    .append("<tr>").append(emplyee.getFired()).append("</td")
                    .append("<tr>").append(emplyee.getSalary()).append("</td")
                    .append("</tr>").append(System.lineSeparator());
        }
            text.append("</table>").append(System.lineSeparator())
                .append("</body>").append(System.lineSeparator())
                .append("</html>").append(System.lineSeparator());
        return text.toString();
    }
}
