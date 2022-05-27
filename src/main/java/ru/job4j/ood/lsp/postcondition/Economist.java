package ru.job4j.ood.lsp.postcondition;

import java.util.ArrayList;

public class Economist {

    protected int minDeposit;

    protected int wagePerTon;

    public Economist(int minDeposit, int wagePerTon) {
        this.minDeposit = minDeposit;
        this.wagePerTon = wagePerTon;
    }

    public int wages(CoalMine coalMine) {
        int factDeposits = 0;
        for (Integer deposits : coalMine.depositsPerLode) {
            factDeposits += deposits;
        }
        if (factDeposits < minDeposit) {
            throw new IllegalArgumentException("Extraction is not profitable!");
        }
        return factDeposits * wagePerTon;
    }
}
