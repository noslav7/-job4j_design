package ru.job4j.io;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ConsoleChat {
    private static final String OUT = "закончить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";
    private final String path;
    private final String botAnswers;
    private static List<String> logText = new ArrayList<>();

    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.botAnswers = botAnswers;
    }

    public void run() throws IOException {
        String typing;
        String answerString;

        while (!(typing = anyWordOrPhrase()).equals(STOP)) {
            System.out.println(answerString = readPhrases().get(0));
            logText.add(typing);
            logText.add(answerString);
        }
        logText.add(STOP);

        while (!(typing = anyWordOrPhrase()).equals(CONTINUE)) {
            logText.add(typing);
        }
        logText.add(CONTINUE);

        while (!(typing = anyWordOrPhrase()).equals(OUT)) {
            System.out.println(answerString = readPhrases().get(0));
            logText.add(typing);
            logText.add(answerString);
        }
        logText.add(OUT);
    }

    private List<String> readPhrases() throws IOException {
        List<String> answers = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(botAnswers, Charset.forName("UTF-8")))) {
            br.lines().map(s -> s + System.lineSeparator()).forEach(answers::add);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Collections.shuffle(answers);
        return answers;
    }

    private void saveLog(List<String> log) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(path, Charset.forName("UTF-8"), true))) {
            logText.forEach(pw::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String anyWordOrPhrase() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        return reader.readLine();
    }

    public static void main(String[] args) throws IOException {
        ConsoleChat cc = new ConsoleChat("./src/data/log.txt", "./src/data/answersPoem.txt");
        cc.run();
        cc.saveLog(logText);
    }
}
