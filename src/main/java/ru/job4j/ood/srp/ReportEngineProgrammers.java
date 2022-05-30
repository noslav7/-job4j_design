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
        text.append("Name; Hired; Fired; Salary;");
        for (Employee employee : store.findBy(filter)) {
                text.append(System.lineSeparator())
                    .append(employee.getName()).append(";")
                    .append(employee.getHired()).append(";")
                    .append(employee.getFired()).append(";")
                    .append(employee.getSalary()).append(";")
                    .append(System.lineSeparator());
        }
        return stringToHTMLString(text.toString());
    }

    public static String stringToHTMLString(String string) {
        StringBuffer sb = new StringBuffer(string.length());
        boolean lastWasBlankChar = false;
        int len = string.length();
        char c;

        for (int i = 0; i < len; i++) {
            c = string.charAt(i);
            if (c == ' ') {
                if (lastWasBlankChar) {
                    lastWasBlankChar = false;
                    sb.append("&nbsp;");
                } else {
                    lastWasBlankChar = true;
                    sb.append(' ');
                }
            } else {
                lastWasBlankChar = false;

                if (c == '&')
                    sb.append("&amp;");
                else if (c == '<')
                    sb.append("&lt;");
                else if (c == '>')
                    sb.append("&gt;");
                else if (c == '\n')
                    sb.append("<br/>");
                else {
                    int ci = 0xffff & c;
                    if (ci < 160) {
                        sb.append(c);
                    }
                    else {
                        sb.append("&#");
                        sb.append(Integer.valueOf(ci).toString());
                        sb.append(';');
                    }
                }
            }
        }
        return sb.toString();
    }
}
