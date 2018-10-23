package chapter1_2_statckandqueue;

import java.util.LinkedList;

public class Parentheses {


    public static boolean isValidParenthese(String str) {
        if (str == null || str.length() <= 0) {
            return false;
        }

        LinkedList<Character> stack = new LinkedList<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else if (stack.isEmpty()) {
                return false;
            } else {
                char popChar = stack.pop();
                if (ch == ')' && popChar != '(') {
                    return false;
                }
                if (ch == ']' && popChar != '[') {
                    return false;
                }
                if (ch == '}' && popChar != '{') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }


    public static void main(String[] args) {
        String str = "[()]{}{[()()]()}";
        String str2 = "[(])";

        System.out.println(isValidParenthese(str));
        System.out.println(isValidParenthese(str2));
    }
}
