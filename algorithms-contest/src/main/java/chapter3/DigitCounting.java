package chapter3;

import java.util.Arrays;

public class DigitCounting {
    
    public static int[] digitCount(String input) {
        if (input == null || input.length() == 0) {
            return new int[0];
        }
        
        int[] result = new int[10];
        
        for (char c : input.toCharArray()) {
            result[c - '0']++;
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        System.out.println(Arrays.toString(digitCount("123456789101112")));
    }
}
