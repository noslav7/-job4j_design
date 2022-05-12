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
        File inputFile = new File("./src/data/inputText.txt");
        if (file.isDirectory()) {
                new DirFileCache(file.getPath());
        } else if (command.equals("inputText.txt")) {
                new Input().load(inputFile.getPath());
        } else if (command.equals("text.txt")) {
            System.out.println(new Output().load(text.getPath()));
        }
    }
    public String getTypeOfCommand() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        return reader.readLine();
    }
}