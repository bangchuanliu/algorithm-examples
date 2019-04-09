package tag.dfs;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class DecodeString {
    public String decodeString(String s) {

        Queue<Character> q = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            q.add(s.charAt(i));
        }
        return decode(q);

    }

    public String decode(Queue<Character> q) {
        String str = "";
        int num = 0;
        while (!q.isEmpty()) {
            char c = q.poll();

            if (Character.isLetter(c)) str += c;
            else if (Character.isDigit(c)) num = num * 10 + c - '0';
            else if (c == ']') {
                break;
            } else {
                String sub = decode(q);
                for (int i = 0; i < num; i++) {
                    str += sub;
                }
                num = 0;
            }
        }

        return str;
    }


    public String decodeString2(String s) {

        if (s == null || s.length() == 0) {
            return s;
        }

        Stack<String> stack = new Stack<>();

        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            }else if (c == '[') {
                stack.push(num+"");
                stack.push(c+"");
                num = 0;
            }else if (c == ']') {
                StringBuilder sb = new StringBuilder();
                while (!stack.isEmpty() && !stack.peek().equals("[")) {
                    sb.insert(0,stack.pop());
                }
                stack.pop();
                int num2 = Integer.parseInt(stack.pop());
                StringBuilder sb2 = new StringBuilder();
                for (int j = 0; j < num2; j++) {
                    sb2.append(sb.toString());
                }
                stack.push(sb2.toString());
            }else {
                stack.push(c+"");
            }
        }
        
        StringBuilder sb2 = new StringBuilder();
        while (!stack.isEmpty()) {
            sb2.insert(0,stack.pop());
        }

        return sb2.toString();
    }
    
    public static void main(String[] args) {
        DecodeString decodeString = new DecodeString();
        String ret = decodeString.decodeString2("3[a]2[bc]");
        System.out.println(ret);
    }
}
