package tag.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenerateParentheses {

	public List<String> generateParenthesis(int n) {
		List<String> result = new ArrayList<>();
		generateParenthesis(result, "", n, n);

		return result;
	}


	public void generateParenthesis(List<String> result, String str, int l, int r) {
		if (l < 0 || r < 0 || l > r) {
			return;
		}

		if (l == 0 && r == 0) {
			result.add(str);
			return;
		}

		generateParenthesis(result, str + '(', l-1,r);
		generateParenthesis(result, str + ')', l,r-1);
	}

	public static void main(String[] args) {
        GenerateParentheses instane = new GenerateParentheses();
        System.out.println(Arrays.toString(instane.generateParenthesis(3).toArray()));
	}
}
