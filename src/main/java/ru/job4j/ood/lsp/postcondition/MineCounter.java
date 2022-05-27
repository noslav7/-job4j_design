package ru.job4j.ood.lsp.postcondition;

import java.util.ArrayList;

public class MineCounter extends Economist {

    public MineCounter(int minDeposit, int wagePerTon) {
        super(minDeposit, wagePerTon);
    }

    @Override
    public int wages(CoalMine coalMine) {
        int factDeposits = 0;
        for (Integer deposit : coalMine.depositsPerLode) {
            factDeposits += deposit;
        }
        return factDeposits * wagePerTon;
    }
}
