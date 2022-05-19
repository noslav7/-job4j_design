package ru.job4j.tdd;

public class AccountCinema implements Account {
    private int startingBalance;

    public AccountCinema(int startingBalance) {
        this.startingBalance = startingBalance;
    }

    @Override
    public int put(int sum) {
        return sum;
    }

    @Override
    public int withdraw(int sum) {
        return sum;
    }
}
