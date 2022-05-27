package ru.job4j.ood.lsp.precondition;

public class Plot extends Field {

    public Plot(int wheat, int grain, int rice, String destination) {
        super(wheat, grain, rice, destination);
    }

    @Override
    public void supply(Field field) {
        if (wheat < 150 || grain < 200 || rice < 1100) {
            throw new IllegalArgumentException("Not enough cargo to arrange delivery!");
        }
        if (!destination.equalsIgnoreCase("Moscow")) {
            throw new IllegalArgumentException("Unable to supply to that place!");
        }
        System.out.println("Перевозится в " + destination);
    }
}

/*
Поскольку одно из первых условие в методе supply(field) - более строгое, нарушено требование о том,
что в классе-наследнике не должно усиливаться какое-либо из условий, указанных в соответствующем методе
класса-предка (предусловие).
 */
