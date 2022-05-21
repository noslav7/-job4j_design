package ru.job4j.ood.srp.violations;

public class TextManipulator {
    private String text;

    public TextManipulator(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void appendText(String newText) {
        text = text.concat(newText);
    }

    public String findWordAndReplace(String word, String replacementWord) {
        if (text.contains(word)) {
            text = text.replace(word, replacementWord);
        }
        return text;
    }

    public String findWordAndDelete(String word) {
        if (text.contains(word)) {
            text = text.replace(word, "");
        }
        return text;
    }

    public void printText() {
        System.out.println(getText());
    }
}

/* Данный класс отвечает по большому счету за два
 типа действий: за действия, связанные с работой над текстом,
 и за печать текста. */