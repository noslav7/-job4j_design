package ru.job4j.ood.lsp.precondition;

public class Shipment {
    public static void main(String[] args) {
        Field shipment = new Plot(1500, 2000, 1000, "Moscow");
        shipment.supply(shipment);
    }
}
