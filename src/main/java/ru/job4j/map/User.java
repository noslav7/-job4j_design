package ru.job4j.map;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.*;
import java.util.concurrent.TimeUnit;

import static java.util.Objects.hash;

public class User {
    private String name;
    private int children;
    private Timestamp birthday;

    public User(String name, int children, Timestamp birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof User)) {
            return false;
        }
        return Objects.equals(this.name, ((User) o).name) && this.children == ((User) o).children
                && this.birthday == ((User) o).birthday;
    }

    @Override
    public int hashCode() {
        int result = birthday.hashCode();
        result = 31 * result + Integer.hashCode(children);
        result = 31 * result + name.hashCode();
        return result;
    }

    public static void main(String[] args) {
        Timestamp irinaStamp = new Timestamp(2021, 4, 9, 20, 10, 5, 0);
        Timestamp vitaliyStamp = new Timestamp(2021, 4, 9, 20, 10, 5, 0);
        User user1 = new User("Катя", 0, irinaStamp);
        User user2 = new User("Катя", 0, irinaStamp);
        Map<User, Object> map = new HashMap<>();
        map.put(user1, new Object());
        map.put(user2, new Object());
        boolean eq = map.get(user1).equals(map.get(user2));
        System.out.println(map);
        System.out.println(eq);
    }
}
