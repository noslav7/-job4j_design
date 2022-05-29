package ru.job4j.ood.dip.violation3;

import java.util.Arrays;
import java.util.List;

public class SQLProductRepository {
    public List<String> getAllProductNames() {
        return Arrays.asList("item1", "item2");
    }
}
