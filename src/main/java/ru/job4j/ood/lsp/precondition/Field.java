package ru.job4j.ood.lsp.precondition;

public class Field {

    int wheat;
    int grain;
    int rice;
    String destination;

    public Field(int wheat, int grain, int rice, String destination) {
        this.wheat = wheat;
        this.grain = grain;
        this.rice = rice;
        this.destination = destination;
    }

    public void supply(Field field) {
        if (wheat < 1500 || grain < 2000 || rice < 900 ) {
            throw new IllegalArgumentException("Not enough cargo to arrange delivery!");
        }
        if (!destination.equalsIgnoreCase("Moscow")) {
            throw new IllegalArgumentException("Unable to supply to that place!");
        }
        System.out.println("Перевозится в " + destination);
    }
}
