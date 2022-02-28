package ru.job4j.question;

import java.util.Set;

public class Analize {

    public static Info diff(Set<User> previous, Set<User> current) {
        int added = 0;
        int edited = 0;
        int deleted = 0;
        for (int i = 0; i < previous.size(); i++) {
            if (!current.contains(previous.get(i))) {
                deleted++;
            }
            if (previous.get().getId() == currentCell.getId()
                        && !previousCell.getName().equals(currentCell.getName())) {
                    edited++;
                }
                if (!previous.contains(currentCell)
                        && !(previousCell.getId() == currentCell.getId())) {
                    added++;
                }
            }
        }
        return new Info(added, edited, deleted);
    }
}
