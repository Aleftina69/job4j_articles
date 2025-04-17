package ru.job4j.algo;

import java.util.Stack;

public class Brackets {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char component : s.toCharArray()) {
            if (component == '{' || component == '[' || component == '(') {
                stack.push(component);
            } else if (component == '}' || component == ']' || component == ')') {
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();
                if ((top == '{' && component != '}')
                        || (top == '[' && component != ']')
                        || (top == '(' && component != ')')) {
                    return false;
                }

            }
        }
        return stack.isEmpty();
    }
}
