package ru.job4j.ood.ocp.violation3;

public class Individual {
    private Gender gender;
    private double salary;
    private int age;
    private String name;

    public Individual(double salary, int age, String name, Gender gender) {
        this.gender = gender;
        this.salary = salary;
        this.age = age;
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public double getSalary() {
        return salary;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }
}
