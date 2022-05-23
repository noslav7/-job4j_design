package ru.job4j.ooa;

public class DogDoorSimulator {
    public static void main(String[] args) {
        DogDoor door = new DogDoor();
        BarkRecogniser recogniser = new BarkRecogniser(door);
        Remote remote = new Remote(door);

        System.out.println();
        recogniser.recognise("Woof!");
        System.out.println("\nFido has gone outside...");
        System.out.println("\nFido's all done...");

        try {
            Thread.currentThread().sleep(10000);
        } catch (InterruptedException e) {
            System.out.println("But he's stuck outside...");

            System.out.println("Fido starts barking...");
            recogniser.recognise("Woof!");
            System.out.println("\nFido's back inside...");
        }
    }
}