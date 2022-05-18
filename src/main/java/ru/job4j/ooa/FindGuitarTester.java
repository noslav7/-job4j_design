package ru.job4j.ooa;

import java.util.Iterator;
import java.util.List;

public class FindGuitarTester {

    public static void main(String[] args) {
        /* Инициализация каталога гитар */
        Inventory inventory = new Inventory();
        initializelnventory(inventory);
        GuitarSpec whatErinLikes = new GuitarSpec(Builder.FENDER, "Stratocastor",
                Type.ELECTRIC, Wood.ALDER, Wood.ALDER);
        List matchinfGuitars = inventory.search(whatErinLikes);
        if (!matchinfGuitars.isEmpty()) {
            System.out.println("Erin, you might like this guitars:");
            for (Iterator i = matchinfGuitars.iterator(); i.hasNext();) {
                Guitar guitar = (Guitar) i.next();
                GuitarSpec spec = guitar.getSpec();
                System.out.println("We have a "
                        + spec.getBuilder() + " " + spec.getModel() + " "
                        + spec.getType() + " guitar:\n "
                        + spec.getBackWood() + " back and sides,\n "
                        + spec.getTopWood() + " top.XnYou can have it for only $"
                        + guitar.getPrice() + "!");
            }
        } else {
            System.out.println("Sorry, Erin, we have nothing for you.");
        }
    }

    private static void initializelnventory(Inventory inventory) {
        /* Включение описаний гитар в каталог. */
    }
}
