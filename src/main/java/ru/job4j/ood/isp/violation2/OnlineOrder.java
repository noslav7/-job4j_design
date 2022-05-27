package ru.job4j.ood.isp.violation2;

public class OnlineOrder implements IOrder {

    @Override
    public void purchase() {
        System.out.println("Item purchased");
    }

    @Override
    public void processPaypalPayment() {
        System.out.println("Transaction complete");
    }
}
