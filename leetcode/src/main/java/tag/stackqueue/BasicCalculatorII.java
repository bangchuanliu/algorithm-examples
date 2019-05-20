package tag.stackqueue;

import java.util.Stack;

public class BasicCalculatorII {

    public int calculate(String s) {
        Stack<Integer> nums = new Stack<>();
        Character op = null;
        int i = 0;
        int sign = 1;
        while (i < s.length()) {
            if (Character.isDigit(s.charAt(i))) {
                int num = s.charAt(i) - '0';
                while (i + 1 < s.length() && Character.isDigit(s.charAt(i+1))) {
                    num = num * 10 + s.charAt(i+1) - '0';
                    i++;
                }
                if (op != null) {
                    int n = nums.pop();
                    if (op == '*') {
                        num = n * num;
                    } else {
                        num = n / num;
                    }
                    op = null;
                }
                nums.push(num * sign);
            } else if (s.charAt(i) == '+') {
                sign = 1;
            } else if (s.charAt(i) == '-') {
                sign = -1;
            } else if (s.charAt(i) == '*' || s.charAt(i) == '/') {
                op = s.charAt(i);
                sign = 1;
            }
            i++;
        }

        int result = 0;
        while (!nums.isEmpty()) {
            result += nums.pop();
        }

        return result;
    }


    public static void main(String[] args) {
        BasicCalculatorII instance = new BasicCalculatorII();
        System.out.println(instance.calculate("1-1+1"));
        System.out.println(instance.calculate(" 3/2 "));
        System.out.println(instance.calculate(" 3+5 / 2 "));
    }

}
