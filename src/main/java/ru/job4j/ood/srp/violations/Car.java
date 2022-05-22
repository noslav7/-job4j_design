package ru.job4j.ood.srp.violations;

public class Car implements CourierTransport {
    @Override
    public void deliver() {
        System.out.println("The parcel is delivered by car ");
    }
}
