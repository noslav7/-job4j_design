package ru.job4j.cache;

public class Emulator {
    private String cachingDir;

    public Emulator() {
    }

    public Emulator(String cachingDir) {
        this.cachingDir = cachingDir;
    }

    public String getCachingDir() {
        return cachingDir;
    }

    public void setCachingDir(String cachingDir) {
        this.cachingDir = cachingDir;
    }

    public static void main(String[] args) {
      /*  String command = getTypeOfCommand()*/

        Emulator emulator = new Emulator();

   /*     emulator.setCachingDir(getTypeOfCommand(command))*/


    }

    public static String getTypeOfCommand(String command) {
        return command;
    }
}