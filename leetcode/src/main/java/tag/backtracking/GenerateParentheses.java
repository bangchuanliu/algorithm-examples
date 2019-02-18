package tag.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
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

	public static void main(String[] args) {
        GenerateParentheses instane = new GenerateParentheses();
        System.out.println(Arrays.toString(instane.generateParenthesis(3).toArray()));
	}
}
