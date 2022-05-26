package ru.job4j.ood.srp;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomNumber implements RandomCreator<Integer> {

    private Random random;

    public RandomNumber(Random random) {
        this.random = random;
    }

    @Override
    public List<Integer> create(int size) {
        return IntStream.range(0, size)
                .map(i -> random.nextInt()).boxed()
                .collect(Collectors.toList());
    }
}

/*
Взаимодействие организовано через абстракции (в данном случае: интерфейс и абстрактный класс Random), за исключением
примитивных типов и не изменяемых типов (в данном случае - класс-обертка Integer).
 */