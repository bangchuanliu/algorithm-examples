package leetcode.easy.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a set of candidate numbers (C) and a target number (T), find all unique
 * combinations in C where the candidate numbers sums to T.
 * 
 * The same repeated number may be chosen from C unlimited number of times.
 * 
 * Note: All numbers (including target) will be positive integers. Elements in a
 * combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤
 * …≤ ak). The solution set must not contain duplicate combinations. For
 * example, given candidate set 2,3,6,7 and target 7, A solution set is: [7]
 * [2,2, 3]
 * 
 * 
 * @author BangChuan Liu
 * @date 2015
 * @Contact liubangchuan1100@gmail.com
 */
public class CombinationSum {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
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
            	if (i > index && candidates[i] == candidates[i-1]) {
            		continue;
            	}
				temp.add(candidates[i]);
				combinationSum(result, candidates, i, target - candidates[i], temp);
				temp.remove(temp.size() - 1);
			}
		}
	}

	public static void main(String[] args) {
		CombinationSum instance = new CombinationSum();
		int[] candidates = { 2, 3, 6, 7 };
		List<List<Integer>> result = instance.combinationSum(candidates, 7);
		System.out.println(Arrays.deepToString(result.toArray()));
	}
}
