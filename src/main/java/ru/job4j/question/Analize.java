package ru.job4j.question;

import java.util.*;

public class Analize {

    public static Info diff(Set<User> previous, Set<User> current) {
        int added = 0;
        int edited = 0;
        int deleted = 0;
        Map<Integer, String> currentMap = new HashMap<>();
        for (User user : current) {
            currentMap.put(user.getId(), user.getName());
        }
        for (User user : previous) {
            currentMap.put(user.getId(), user.getName());
            if (...) {
                deleted++;
            }
            if (...) {
                added++;
            }
            if (...) {
                edited++;
            }
        }
        return new Info(added, edited, deleted);
    }
}
