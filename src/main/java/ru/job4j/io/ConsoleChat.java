package ru.job4j.io;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class ConsoleChat {
    private static final String OUT = "закончить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";
    private final String path;
    private final String botAnswers;
    private static List<String> logText = new ArrayList<>();


    public ConsoleChat(String path, String botAnswers) throws IOException {
        this.path = path;
        this.botAnswers = botAnswers;
    }

    public void run() throws IOException {
        String typing = anyWordOrPhrase();
        List<String> answerString = readPhrases();
        Random random = new Random();

        while (!typing.equals(STOP)) {
            System.out.println(answerString.get(random.nextInt(answerString.size())));
            logText.add(typing);
            logText.add(answerString.get(random.nextInt(answerString.size())));
            typing = anyWordOrPhrase();
        }
        logText.add(STOP);

        typing = anyWordOrPhrase();
        while (!typing.equals(CONTINUE)) {
            logText.add(typing);
            typing = anyWordOrPhrase();
        }
        logText.add(CONTINUE);

        typing = anyWordOrPhrase();
        while (!typing.equals(OUT)) {
            System.out.println(answerString.get(random.nextInt(answerString.size())));
            logText.add(typing);
            logText.add(answerString.get(random.nextInt(answerString.size())));
            typing = anyWordOrPhrase();
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
