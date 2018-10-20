package statckandqueue;

import java.util.LinkedList;


/**
 * '*' and '/' are superior to '+' and '-'
 * '()' has most privilege
 * <p>
 * assume the expression is valid
 * <p>
 * add implicit brackets into expression
 */
public class InfixToPostfix {

    public static void addBracket(String str) {
        if (str == null || str.length() <= 0) {
            return;
        }
        int leftBracket = 0;
        LinkedList<String> expressions = new LinkedList<>();
        LinkedList<Character> ops = new LinkedList<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == ' ') {
                continue;
            }
            if (ch == '+' || ch == '-') {
                if (expressions.size() > 1 && leftBracket == 0) {
                    String exp1 = expressions.pop();
                    String exp2 = expressions.pop();
                    char op = ops.pop();
                    expressions.push("(" + exp2 + op + exp1 + ")");
                }
                ops.push(ch);
            } else if (ch == '*' || ch == '/') {
                ops.push(ch);
            } else if (ch == ')') {
                String exp1 = expressions.pop();
                String exp2 = expressions.pop();
                char op = ops.pop();
                expressions.push("(" + exp2 + op + exp1 + ")");
                leftBracket--;
            } else if (ch == '(') {
                leftBracket++;
            } else {
                expressions.push(String.valueOf(ch));
            }
        }
        while (!ops.isEmpty()) {
            String exp1 = expressions.pop();
            String exp2 = expressions.pop();
            char op = ops.pop();
            expressions.push("(" + exp2 + op + exp1 + ")");
        }
        System.out.println(expressions.pop());
    }


    public static void infixToPostFix(String str) {

    }

    public static void main(String[] args) {
        String str = "1+2";
        String str2 = "1+2*3-4*5-6";
        String str3 = "1 * 2 + 3 / 4";
        String str4 = "1 * (2 + 3) / 4";
        String str5 = "1 * (2 + 3 / 4)";
        String str6 = "1 * 2 * 3";
        addBracket(str);
        addBracket(str2);
        addBracket(str3);
        addBracket(str4);
        addBracket(str5);
        addBracket(str6);
    }
}
