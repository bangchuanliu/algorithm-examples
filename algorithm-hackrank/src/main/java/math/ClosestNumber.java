package math;

import java.io.*;

/**
 * Hello world!
 */
public class ClosestNumber {
    public String decodeString(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        return decode(s);
    }

    static int index = 0;

    public String decode(String s) {
        String ret = "";
        while(index < s.length()) {
            char c = s.charAt(index);
            if (c >= '0' && c <= '9') {
                int count = c - '0';
                index = index + 2;
                String ss = decode(s);
                for (int i = 0; i < count; i++) {
                    ret = ret + ss;
                }
            } else if (c == ']') {
                return ret;
            } else {
                ret = ret + String.valueOf(c);
            }
            index++;
        }
        return ret;
    }


    public static void main(String[] args) throws IOException {
        System.out.println(new ClosestNumber().decodeString("3[a2[c]]"));
    }
}
