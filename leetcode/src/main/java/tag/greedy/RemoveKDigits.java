package tag.greedy;

import java.util.Stack;

public class RemoveKDigits {
    public String removeKdigits(String num, int k) {
        if (k >= num.length()) {
            return "0";
        }

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < num.length(); i++) {
            while (!stack.isEmpty() && num.charAt(i) - '0' < stack.peek() && k > 0) {
                stack.pop();
                k--;
            }
            stack.push(num.charAt(i) - '0');
        }

        while (k > 0) {
            stack.pop();
            k--;
        }
        
        String str = "";

        while (!stack.isEmpty()) {
            str = stack.pop() + str;
        }
        int i = 0;
        while (i < str.length() && str.charAt(i) == '0') {
            i++;
        }

        return str.substring(i).isEmpty() ? "0" : str.substring(i);
    }

    public static void main(String[] args) {
        RemoveKDigits removeKDigits = new RemoveKDigits();

        System.out.println(removeKDigits.removeKdigits("1432219", 3));
        System.out.println(removeKDigits.removeKdigits("10200", 1));
        System.out.println(removeKDigits.removeKdigits("10", 2));
    }
}
