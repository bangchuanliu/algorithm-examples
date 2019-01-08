package leetcode.easy.diveconquer;

import java.util.ArrayList;
import java.util.List;

public class DifferentWaystoAddParentheses {

	public List<Integer> diffWaysToCompute(String input) {
		List<Integer> result = new ArrayList<>();

		if (input == null || input.length() == 0) {
			return result;
		}

		for (int i = 0; i < input.length(); i++) {
			if (!Character.isDigit(input.charAt(i))) {
				List<Integer> numOfWays1 = diffWaysToCompute(input.substring(0, i));
				List<Integer> numOfWays2 = diffWaysToCompute(input.substring(i + 1));

				for (int a : numOfWays1) {
					for (int b : numOfWays2) {
						result.add(calculate(a, b, input.charAt(i)));
					}
				}
			}
		}

		if (result.isEmpty()) {
			result.add(Integer.parseInt(input));
		}

		return result;
	}

	public int calculate(int a, int b, char op) {
		if (op == '+') {
			return a + b;
		} else if (op == '-') {
			return a - b;
		} else { // *
			return a * b;
		}
	}
}
