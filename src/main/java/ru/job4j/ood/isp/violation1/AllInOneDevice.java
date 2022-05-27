package ru.job4j.ood.isp.violation1;

public class AllInOneDevice implements SmartDevice {

    @Override
    public void print() {
        System.out.println("Printing");
    }

    @Override
    public void fax() {
        System.out.println("Receiving fax");
    }

    @Override
    public void scan() {
        System.out.println("Scanning");
    }
}

/*

 */