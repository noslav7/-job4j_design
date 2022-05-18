package ru.job4j.tdd;

import ru.job4j.list.List;

public interface Ticket {
    List<Ticket> obtain();

    Ticket use();

    Ticket sell();
}
