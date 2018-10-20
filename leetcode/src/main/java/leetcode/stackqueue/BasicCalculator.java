package leetcode.stackqueue;

import java.util.Stack;

public class BasicCalculator {

	public int calculate(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		s = s.replace(" ", "");
		int sign = 1;
		int result = 0;

		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < s.length(); i++) {
			if (Character.isDigit(s.charAt(i))) {
				int sum = s.charAt(i) - '0';
				while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
					sum = sum * 10 + s.charAt(i + 1) - '0';
					i++;
				}
				result += sum * sign;
			} else if (s.charAt(i) == '+') {
				sign = 1;
			} else if (s.charAt(i) == '-') {
				sign = -1;
			} else if (s.charAt(i) == '(') {
				stack.push(result);
				stack.push(sign);
				result = 0;
				sign = 1;
			} else if (s.charAt(i) == ')') {
				result = result * stack.pop() + stack.pop();
			}
		}

		return result;
	}

	public static void main(String[] args) {
		BasicCalculator instance = new BasicCalculator();
		System.out.println(instance.calculate("1 + 1"));
		System.out.println(instance.calculate(" 2-1 + 2 "));
		System.out.println(instance.calculate("(1+(4+5+2)-3)+(6+8)"));
	}
}
