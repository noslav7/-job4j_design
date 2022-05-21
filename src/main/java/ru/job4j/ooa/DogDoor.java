package ru.job4j.ooa;

public class DogDoor {

    private boolean open;

    public DogDoor() {
        this.open = false;
    }

    public void open() {
        System.out.println("The dog door opens.");
        open = true;
    }

    public void close() {
        System.out.println("The dog door closes.");
        open = true;
    }
    public boolean isOpen() {
        return open;
    }
}
