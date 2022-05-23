package ru.job4j.ooa;

import java.util.Timer;
import java.util.TimerTask;

public class DogDoor {

    private boolean open;

    public DogDoor() {
        this.open = false;
    }

    public void open() {
        System.out.println("The dog door opens.");
        open = true;
    }

    final Timer timer = new Timer();
    timer.schedule(new TimerTask() {
        public void run() {
            close();
            timer.cancel();
        }
    }, 5000);

    public void close() {
        System.out.println("The dog door closes.");
        open = true;
    }
    public boolean isOpen() {
        return open;
    }
}
