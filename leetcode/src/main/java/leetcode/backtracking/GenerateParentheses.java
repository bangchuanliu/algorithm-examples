package leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author bangliu
 * 
 */
public class GenerateParentheses {

	public List<String> generateParenthesis(int n) {
		List<String> parentheses = new ArrayList<>();
		if (n <= 0) {
			return parentheses;
		}

		generateParenthesis(parentheses, n, n, "");
		return parentheses;
	}

	public void generateParenthesis(List<String> parentheses, int left, int right, String s) {
		if (left > right) {
			return;
		}

		if (left == 0 && right == 0) {
			parentheses.add(s);
		}

		if (left > 0) {
			generateParenthesis(parentheses, left - 1, right, s + "(");
		}

		if (right > 0) {
			generateParenthesis(parentheses, left, right - 1, s + ")");
		}
	}

	// StringBuilder 
	public void generateParenthesis(List<String> result, int left, int right, StringBuilder sb) {
		if (left > right || left < 0 || right < 0) {
			return;
		}
		if (left == 0 && right == 0) {
			result.add(sb.toString());
			return;
		}

		sb.append("(");
		generateParenthesis(result, left - 1, right, sb);
		sb.deleteCharAt(sb.length() - 1);

		sb.append(")");
		generateParenthesis(result, left, right - 1, sb);
		sb.deleteCharAt(sb.length() - 1);
	}
}
