package ru.job4j.ood.srp.violations;

public class Truck implements CourierTransport {
    @Override
    public void deliver() {
        System.out.println("Cargo is delivered by truck");
    }
}
