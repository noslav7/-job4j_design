package ru.job4j.question;

import java.util.*;

public class Analize {

    public static Info diff(Set<User> previous, Set<User> current) {
        int added = 0;
        int edited = 0;
        int deleted = 0;
        Map<Integer, String> previousMap = new HashMap<>();
        for (User user : previous) {
            previousMap.put(user.getId(), user.getName());
        }
        for (User user : current) {
            previousMap.put(user.getId(), user.getName());
            if (previousMap.size() + 1 == current.size() && !previousMap.containsKey(user.getId())) {
                added++;
            }
            if ((previousMap.size() == current.size()) && previousMap.containsKey(user.getId())) {
                edited++;
            }
            if (previousMap.size() - 1 == current.size() && !previousMap.containsKey(user.getId())) {
                deleted++;
            }
        }
        return new Info(added, edited, deleted);
    }
}
