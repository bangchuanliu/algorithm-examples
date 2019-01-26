package tag.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		List<List<Integer>> result = new ArrayList<>();
		if (candidates == null || candidates.length == 0 || target <= 0) {
			return result;
		}

		Arrays.sort(candidates);

		List<Integer> temp = new ArrayList<>();

		combinationSum(result, candidates, 0, target, temp);

		return result;
	}

	public void combinationSum(List<List<Integer>> result, int[] candidates, int index, int target,
			List<Integer> temp) {
		if (target == 0) {
			result.add(new ArrayList<>(temp));
			return;
		}

		if (target > 0) {
			for (int i = index; i < candidates.length; i++) {
				if (i > index && candidates[i] == candidates[i - 1]) {
					continue;
				}
				temp.add(candidates[i]);
				combinationSum(result, candidates, i + 1, target - candidates[i], temp);
				temp.remove(temp.size() - 1);
			}
		}
	}

	public static void main(String[] args) {
		CombinationSumII instance = new CombinationSumII();
		int[] candidates = { 1, 1, 7 };
		List<List<Integer>> result = instance.combinationSum2(candidates, 1);
		System.out.println(Arrays.deepToString(result.toArray()));
	}
}
