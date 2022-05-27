package ru.job4j.ood.isp.violation3;

public class LightCruiser implements Spaceship {

    @Override
    public String fly() {
        return "Flying to space!";
    }

    @Override
    public String land() {
        return "Landing...";
    }

    @Override
    public String shoot() {
        return "Bang! Bang! Lasers!";
    }

    @Override
    public String doScience() {
        return "Magnets... How do they work?";
    }
}
