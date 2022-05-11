package ru.job4j.cache;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class Emulator {

    public static void main(String[] args) throws IOException {

        Emulator emulator = new Emulator();
        String command = emulator.getTypeOfCommand();
        File file = new File(command);
        File text = new File("./src/data/poem.txt");
        if (file.isDirectory()) {
                new DirFileCache(text.getPath()).load(text.getPath());
        } else if (command.equals("load")) {
                new Input(text.getPath()).load(text.getPath());
        } else if (command.equals("retrieve")) {
                new Output(text.getPath()).load(text.getPath());
        }
    }

    private void setCachingDir(String command) {


    }

    public String getTypeOfCommand() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        return reader.readLine();
    }
}