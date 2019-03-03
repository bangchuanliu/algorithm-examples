package tag.dfs;

import java.util.ArrayDeque;
import java.util.Queue;

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
}
