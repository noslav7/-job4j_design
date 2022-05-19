package ru.job4j.tdd;

import ru.job4j.list.List;

public class Ticket3D implements Ticket {
    private int ticketPossessed;
    @Override
    public int obtain() {
        return ticketPossessed++;
    }

    @Override
    public int use() {
        return ticketPossessed--;
    }

    @Override
    public int sell() {
        return ticketPossessed--;
    }
}
