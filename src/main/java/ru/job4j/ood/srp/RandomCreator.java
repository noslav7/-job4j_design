package ru.job4j.ood.srp;

import java.util.List;

public interface RandomCreator<T> {
    List<T> create(int size);
}
