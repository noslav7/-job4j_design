package ru.job4j.ood.dip.violation3;

public class ProductCatalog {
    public void listAllProducts() {
        SQLProductRepository sqlProductRepository = new SQLProductRepository();
        sqlProductRepository.getAllProductNames();
    }
}

/*
Данный пример кода нарушает принцип DIP, поскольку классы ProductCatalog и SQLProductRepository
зависят от продукта (продуктов), класс ProductCatalog зависит от класса SQLProductRepository, в то
время как код обоих данных классов должен зависеть от кода абстракций.
 */