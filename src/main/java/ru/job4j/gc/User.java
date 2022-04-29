package ru.job4j.gc;

public class User {
    private int age;
    private short height;

    public User(int age) {
        this.age = age;
    }

    public User(short height) {
        this.height = height;
    }

    public User(int age, short height) {
        this.age = age;
        this.height = height;
    }

    public User() {
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.printf("Removed %d %s%n", age, height);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public short getHeight() {
        return height;
    }

    public void setHeight(short height) {
        this.height = height;
    }

    public static void main(String[] args) {

    }
}
