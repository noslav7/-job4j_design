package ru.job4j.ood.lsp.postcondition;

public class Extraction {
    public static void main(String[] args) {
        CoalMine deposits = new CoalMine();
        deposits.add(7);
        deposits.add(15);
        deposits.add(12);
        deposits.add(14);
        deposits.add(8);
        deposits.add(17);
        deposits.add(13);

        Economist countingRoom = new MineCounter(10, 1000);
        System.out.println(countingRoom.wages(deposits));
    }
}
