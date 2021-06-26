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
                return str;
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
    static int index = 0;
    // use global variable to store the index
    public String decodeString2(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        String ret = "";
        int num = 0;
        while(index < s.length()) {
            char c =  s.charAt(index);
            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            }else if (c == '[') {
                index = index + 1;
                String temp = decodeString2(s);
              for (int i = 0; i < num; i++) {
                  ret = ret + temp;
              }
              num = 0;
            } else if(c == ']') {
                return ret;
            } else {
                ret  = ret + c;
            }
            index++;
        }
        return ret;
    }
    
    public static void main(String[] args) {
        DecodeString decodeString = new DecodeString();
        String ret = decodeString.decodeString2("3[a]2[bc]");
        System.out.println(ret);
    }
}
