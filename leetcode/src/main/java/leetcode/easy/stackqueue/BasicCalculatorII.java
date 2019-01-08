package leetcode.easy.stackqueue;

import java.util.Stack;

public class BasicCalculatorII {

	public int calculate(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		s = s.replace(" ", "");

		Stack<Integer> stack = new Stack<>();
		Stack<Character> op = new Stack<>();

		for (int i = 0; i < s.length(); i++) {
			if (Character.isDigit(s.charAt(i))) {
				int sum = s.charAt(i) - '0';
				while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
					sum = sum * 10 + s.charAt(i + 1) - '0';
					i++;
				}
				if (!op.isEmpty() && (op.peek() == '*' || op.peek() == '/')) {
					while (!op.isEmpty() && (op.peek() == '*' || op.peek() == '/')) {
						Character ope = op.pop();
						int a = stack.pop();
						stack.push(cal(a, sum, ope));
					}
				} else {
					stack.push(sum);
				}
			} else {
				op.push(s.charAt(i));
			}
		}

		int result = 0;
		while (!op.isEmpty()) {
			Character ope = op.pop();
			int a = stack.pop();
			result = cal(result, a, ope);
		}
		return stack.pop() + result;
	}

	
	public int cal(int a, int b, Character op) {
		if (op == '+') {
			return a + b;
		} else if (op == '-') {
			return a - b;
		} else if (op == '*') {
			return a * b;
		} else {
			if (b == 0) {
				return 0;
			} else {
				return a / b;
			}
		}
	}

	public static void main(String[] args) {
		BasicCalculatorII instance = new BasicCalculatorII();
		System.out.println(instance.calculate("1-1+1"));
		System.out.println(instance.calculate(" 3/2 "));
		System.out.println(instance.calculate(" 3+5 / 2 "));
	}

}
