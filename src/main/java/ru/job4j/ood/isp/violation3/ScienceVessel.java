package ru.job4j.ood.isp.violation3;

public class ScienceVessel implements Spaceship {

    @Override
    public String fly() {
        return "Flying scientifically!";
    }

    @Override
    public String land() {
        return "Landing cautiously...";
    }

    @Override
    public String shoot() {
        return "Help! I'm unarmed!";
    }

    @Override
    public String doScience() {
        return "Gathering data on nearest neutron star...";
    }
}
