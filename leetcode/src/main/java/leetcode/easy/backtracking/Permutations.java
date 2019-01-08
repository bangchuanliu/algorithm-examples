package leetcode.easy.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {

	public List<List<Integer>> permute(int[] nums) {

		List<List<Integer>> result = new ArrayList<>();

		if (nums == null || nums.length == 0) {
			return result;
		}
		
		List<Integer> temp = new ArrayList<>();
		boolean[] used = new boolean[nums.length];
		
		permute(result, used, nums, temp);

		return result;
	}

	public void permute(List<List<Integer>> result, boolean[] used, int[] nums, List<Integer> temp) {

		if (temp.size() == nums.length) {
			result.add(new ArrayList<>(temp));
			return;
		}

		for (int i = 0; i < nums.length; i++) {
			if (!used[i]) {
				used[i] = true;
				temp.add(nums[i]);
				permute(result, used, nums, temp);
				temp.remove(temp.size() - 1);
				used[i] = false;
			}
		}
	}
	
	public static void main(String[] args) {
		int[] nums = {1,1,2};
		Permutations instance = new Permutations();
		List<List<Integer>> result = instance.permute(nums);
		System.out.println(Arrays.toString(result.toArray()));
	}
}
