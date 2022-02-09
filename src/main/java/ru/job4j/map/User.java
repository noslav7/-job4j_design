package ru.job4j.map;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

public class User {
    private String name;
    private int children;
    private Calendar birthday;

    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    public static void main(String[] args) {
        Calendar irinaCalendar = new GregorianCalendar(1989, 4, 9);
        Calendar vitaliyCalendar = new GregorianCalendar(2019, 4, 9);
        User user1 = new User("Ирина", 1, irinaCalendar);
        User user2 = new User("Виталий", 0, vitaliyCalendar);
        Map<User, Object> map = new HashMap<>();
        map.put(user1, new Object());
        map.put(user2, new Object());
        System.out.println(map);
    }
}
