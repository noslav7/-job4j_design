package ru.job4j.ooa;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

public class Inventory {
    private List guitars;

    public Inventory() {
        guitars = new LinkedList();
    }

    public void addGuitar(String serialNumber, double price) {
        Guitar guitar = new Guitar(serialNumber, price);
        guitars.add(guitar);
    }

    public Guitar getGuitar(String serialNumber) {
        Guitar guitar = null;
        for (Iterator i = guitars.iterator(); i.hasNext();) {
            guitar = (Guitar) i.next();

            if (guitar.getSerialNumber().equals(serialNumber)) {
                return guitar;
            }
        }
        return guitar;
    }

    public List search(GuitarSpec searchSpec) {
        List matchingGuitars = new LinkedList();
        for (Iterator i = guitars.iterator(); i.hasNext();) {
            Guitar guitar = (Guitar) i.next();
            GuitarSpec guitarSpec = guitar.getSpec();
            if (searchSpec.getBuilder() != guitarSpec.getBuilder()) {
                continue;
            }
            String model = searchSpec.getModel();
            if ((model != null) && (!model.equals(""))
                    && (!model.equals(guitarSpec.getModel().toLowerCase(Locale.ROOT)))) {
                continue;
            }
            if (searchSpec.getType() != guitarSpec.getType()) {
                continue;
            }
            if (searchSpec.getBackWood() != guitarSpec.getBackWood()) {
                continue;
            }
            if (searchSpec.getTopWood() != guitarSpec.getTopWood()) {
                continue;
            }
            matchingGuitars.add(guitar);
        }
        return matchingGuitars;
    }
}
