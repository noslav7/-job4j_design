package ru.job4j.gc;

public class Memory {

    public static void main(String[] args) {
        for (int i = 0; i < 527_000_000; i++) {
            new User(15, (short) 163); /* 8 bytes (Object reference) + 4 bytes (int) + 2 bytes (short) = 14 bytes */
            new User(5); /* 8 bytes (Object reference) + 4 bytes (int) = 12 bytes */
            new User(170); /* 8 bytes (Object reference) + 2 bytes (short) = 10 bytes */
            new User(); /* 8 bytes (Object reference) */
        }
    }
}

/*
Currently, maximum heap size is set to 2007 Mb. Hence, creating objects worth 42 bytes overall 527_000_000 times
 should result in the Heap overflow and an automatic launch of GC.
 */
