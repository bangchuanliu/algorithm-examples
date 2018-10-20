package leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bliu13 Jan 14, 2016
 */
public class CombinationSumIII {

	public List<List<Integer>> combinationSum3(int k, int n) {
		List<List<Integer>> result = new ArrayList<>();

		if (k <= 0 || n <= 0) {
			return result;
		}

		List<Integer> temp = new ArrayList<>();

		combinationSum(result, temp, k, n, 1);

		return result;
	}

	public void combinationSum(List<List<Integer>> result, List<Integer> temp, int k, int n, int cur) {
		if (temp.size() == k && n == 0) {
			result.add(new ArrayList<>(temp));
			return;
		}

		if (temp.size() < k && n > 0) {
			for (int i = cur; i <= 9; i++) {
				temp.add(i);
				combinationSum(result, temp, k, n - i, i + 1);
				temp.remove(temp.size() - 1);
			}
		}
	}
}
