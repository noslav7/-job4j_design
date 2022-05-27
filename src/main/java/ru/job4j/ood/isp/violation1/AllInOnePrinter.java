package ru.job4j.ood.isp.violation1;

public class AllInOnePrinter implements SmartDevice {
    @Override
    public void print() {
        System.out.println("I can print");
    }

    @Override
    public void fax() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void scan() {
        throw new UnsupportedOperationException();
    }
}

/*
Поскольку все методы собраны в одном интерфейсе SmartDevice, то при реализации этого интерфейса
каждому устройству необходимо реализовывать все методы интерфейса, что гораздо чаще неуместно,
нежели наоборот. Ошибка ISP.
 */