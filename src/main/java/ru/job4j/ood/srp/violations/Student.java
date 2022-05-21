package ru.job4j.ood.srp.violations;

public class Student {
    private String firstName;
    private String lastName;
    private int age;
    long fee;
    String attendance;

    public long calculateFee() {
        return fee;
    }

    public void save() {

    }

    public String reportAttendance() {
        return attendance;
    }
}

/*  В данном случае, класс Student отвечает не только за сохранение данных студента,
но также за расчет выплат, за получение информации о посещаемости, за сохранение
данных студента в БД.
 */