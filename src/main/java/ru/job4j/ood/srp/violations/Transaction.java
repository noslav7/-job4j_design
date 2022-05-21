package ru.job4j.ood.srp.violations;

public class Transaction {

    // Method to Buy, implemented in Transaction class
    private void Buy(String stock, int quantity, float price){
        // Buy stock functinality implemented here
    }
    // Method to Sell, implemented in Transaction class
    private void Sell(String stock, int quantity, float price){
        // Sell stock functionality implemented here
    }
}

/* Нарушается принцип SRP, поскольку один класс Transaction
 отвечает и за покупку, и за продажу. */