package ru.job4j.question;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Analize {

    public static Info diff(Set<User> previous, Set<User> current) {
        int added = 0;
        int edited = 0;
        int deleted = 0;
        List<User> previousList = new ArrayList<>(previous);
        List<User> currentList = new ArrayList<>(current);
        for (int i = 0; i < previousList.size(); i++) {
            if (!current.contains(previousList.get(i))) {
                deleted++;
            }
        }
        for (int i = 0; i < currentList.size(); i++) {
        if (!previousList.contains(currentList.get(i))) {
            added++;
        }
        }
        return new Info(added, edited, deleted);
    }
}
