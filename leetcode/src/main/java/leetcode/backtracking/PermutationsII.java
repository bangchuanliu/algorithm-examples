package leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsII {
	public List<List<Integer>> permuteUnique(int[] nums) {

		List<List<Integer>> result = new ArrayList<>();

		if (nums == null || nums.length == 0) {
			return result;
		}

		List<Integer> temp = new ArrayList<>();

		Arrays.sort(nums);
		boolean[] used = new boolean[nums.length];
		permute(result, used, nums, temp);

		return result;
	}

	public void permute(List<List<Integer>> result, boolean[] used, int[] nums, List<Integer> temp) {

		if (temp.size() == nums.length) {
			result.add(new ArrayList<>(temp));
			return;
		}

		long lastNumber = Long.MAX_VALUE;

		for (int i = 0; i < nums.length; i++) {
			if (!used[i] && nums[i] != lastNumber) {
				used[i] = true;
				lastNumber = nums[i];
				temp.add(nums[i]);
				permute(result, used, nums, temp);
				temp.remove(temp.size() - 1);
				used[i] = false;
			}
		}
	}

	public static void main(String[] args) {
		int[] nums = {1, 1, 2};
		PermutationsII instance = new PermutationsII();
		List<List<Integer>> result = instance.permuteUnique(nums);
		System.out.println(Arrays.toString(result.toArray()));
	}
}
