package statckandqueue;

import java.util.LinkedList;

public class InfixExpression {

    /**
     * given infix expression with right brackets,
     * add left brackets
     */
    public static void addLeftBrackets(String str) {
        if (str == null || str.length() <= 0) {
            return;
        }

        LinkedList<String> expressions = new LinkedList<>();
        LinkedList<Character> ops = new LinkedList<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '+' || ch == '-' || ch == '*') {
                ops.push(ch);
            } else if (ch == ')') {
                String exp1 = expressions.pop();
                String exp2 = expressions.pop();
                String newExp = '(' + exp2 + ops.pop() + exp1 + ')';
                expressions.push(newExp);
            } else {
                expressions.push(String.valueOf(ch));
            }
        }
        System.out.println(expressions.pop());
    }

    public static void main(String[] args) {
        String str = "1+2)";
        String str2 = "1+2)*3-4)*5-6)))";
        addLeftBrackets(str);
        addLeftBrackets(str2);
    }
}
