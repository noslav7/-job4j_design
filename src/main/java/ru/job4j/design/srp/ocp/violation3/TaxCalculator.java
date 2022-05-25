package ru.job4j.design.srp.ocp.violation3;

public class TaxCalculator {
    /*
     * Tax slab female = 20% on taxable income
     * Tax slab male = 25% on taxable
     * income Tax slab senior = 18% on taxable income
     */
    public double calculateTax(Individual individual) {
        double tax = 0;
        switch (individual.getGender()) {
            case MALE:
                tax = 0.25 * individual.getSalary();
                break;
            case FEMALE:
                tax = 0.20 * individual.getSalary();
                break;
            case SR_CITIZEN_FEMALE:
                tax = 0.17 * individual.getSalary();
                break;
            default:
                /* Handler exception condition */
                System.out.println("Unknow choice");
                tax = -1;
                break;
        }
        return tax;
    }
}
