package ru.job4j.ood.lsp.postcondition;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CoalMine {

    protected List<Integer> depositsPerLode = new ArrayList<>();

    public void add(int tones) {
        depositsPerLode.add(tones);
    }
}
