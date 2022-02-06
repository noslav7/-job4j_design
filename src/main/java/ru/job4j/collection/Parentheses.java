package ru.job4j.collection;

import java.util.Stack;

public class Parentheses {

    public static boolean valid(char[] data) {
        boolean valid = true;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < data.length; i++) {
            char ch = data[i];
            if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                if (stack.isEmpty()) {
                    valid = false;
                    stack.push(ch);
                    break;
                } else {
                    stack.pop();
                }
            }
        }
        return stack.isEmpty();
    }
}
