package ru.job4j.ood.srp.violations;

public class TruckCreator extends CourierTransportCreator {
    @Override
    public CourierTransport createTransport() {
        return new Truck();
    }
}
