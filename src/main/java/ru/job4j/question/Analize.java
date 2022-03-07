package ru.job4j.question;

import java.util.*;

public class Analize {

    public static Info diff(Set<User> previous, Set<User> current) {
        int added = 0;
        int changed = 0;
        int deleted = 0;
        Map<Integer, String> previousMap = new HashMap<>();
        for (User user : previous) {
            previousMap.put(user.getId(), user.getName());
        }
        Map<Integer, String> currentMap = new HashMap<>();
        for (User user : current) {
            currentMap.put(user.getId(), user.getName());
        }
        for (User user : previous) {
            String name = currentMap.put(user.getId(), user.getName());
            if (Objects.equals(name, null)) {
                deleted++;
            }
        }
        for (User user : current) {
            String name = previousMap.put(user.getId(), user.getName());
            if (Objects.equals(name, null)) {
                added++;
            } else if (!previousMap.containsValue(name)) {
                changed++;
            }
        }
        return new Info(added, changed, deleted);
    }
}
