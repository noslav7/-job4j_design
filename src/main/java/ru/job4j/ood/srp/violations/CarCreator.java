package ru.job4j.ood.srp.violations;

public class CarCreator extends CourierTransportCreator {
    @Override
    public CourierTransport createTransport() {
        return new Car();
    }
}
