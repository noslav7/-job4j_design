package ru.job4j.ood.ocp.violation3;

public class CharteredAccountant {
    public static void main(String[] args) {
        Individual sharon = new Individual(1000, 25, "Sharon", Gender.FEMALE);
        Individual nicola = new Individual(1000, 45, "Nicola", Gender.FEMALE);
        Individual gretzky = new Individual(1000, 40, "Gretzky", Gender.MALE);
        Individual howe = new Individual(1000, 65, "Howe", Gender.MALE);
        Individual kim = new Individual(1000, 61, "Kim", Gender.SR_CITIZEN_FEMALE);

        TaxCalculator taxCalculator = new TaxCalculator();
        System.out.println("1. Tax liability of Sharon is: " + taxCalculator.calculateTax(sharon));
        System.out.println("2. Tax liability of Nicola is: " + taxCalculator.calculateTax(nicola));
        System.out.println("3. Tax liability of Gretzky is: " + taxCalculator.calculateTax(gretzky));
        System.out.println("4. Tax liability of Howe is: " + taxCalculator.calculateTax(howe));
        System.out.println("5. Tax liability of Kim is: " + taxCalculator.calculateTax(kim));
    }
}

/*
С каждым последующим добавлением нового налогоплательщика, в данном случае будет необходимо внести изменение в
существующий код, добавив новый возможность переключения на нового налогоплательщика в классе TaxCalculator.
Таким образом, данный код не открыт для расширения.
 */
