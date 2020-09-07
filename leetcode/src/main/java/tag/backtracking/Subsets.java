package tag.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {

	public List<List<Integer>> generateSubsets(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		generateSubsets2(result, 0, nums, new ArrayList<>());
		return result;
	}

	/**
	 * bit vector
	 */
	public void generateSubsets(List<List<Integer>> result, int index, int[] nums, List<Integer> temp) {
		if (index == nums.length) {
			result.add(new ArrayList<>(temp));
			return;
		}
		// current num is in subset
		temp.add(nums[index]);
		generateSubsets(result, index + 1, nums, temp);

		// current num is not in subset
		temp.remove(temp.size() - 1);
		generateSubsets(result, index + 1, nums, temp);
	}

	/**
	 * backtracking
	 */
	public void generateSubsets2(List<List<Integer>> result, int index, int[] nums, List<Integer> temp) {
		result.add(new ArrayList<>(temp));

		for (int i = index; i < nums.length; i++) {
			temp.add(nums[i]);
			generateSubsets2(result, i + 1, nums, temp);
			temp.remove(temp.size() - 1);
		}
	}

	// use array to store each combination
	public static void subset(int[] nums, List<List<Integer>> result, Integer[] temp, int index, int cur) {
		result.add(new ArrayList<>(Arrays.asList(Arrays.copyOfRange(temp, 0, cur))));

		for (int i = index; i < nums.length; i++) {
			temp[cur] = nums[i];
			subset(nums, result, temp, i + 1, cur + 1);
		}
	}

	// use array to store each combination
	public static void subset2(int[] nums, List<List<Integer>> result, Integer[] temp, int index, int cur) {
		if (index == nums.length) {
			result.add(new ArrayList<>(Arrays.asList(Arrays.copyOfRange(temp, 0, cur))));
		}

		subset(nums, result, temp, index + 1, cur);
		temp[cur] = nums[index];
		subset(nums, result, temp, index + 1, cur + 1);
	}
	

	public static void main(String[] args) {
		int[] nums = {1,2,3};
		Subsets instance = new Subsets();
		List<List<Integer>> result = instance.generateSubsets(nums);
		System.out.println(Arrays.toString(result.toArray()));
	}
}
