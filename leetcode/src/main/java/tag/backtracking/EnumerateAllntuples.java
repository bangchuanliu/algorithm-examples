package tag.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EnumerateAllntuples {
	
	public List<List<Integer>> allNTuples(int[] nums) {
		
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> temp = new ArrayList<>();
		
		allNTuples(result, nums, temp);
		return result;
	}
	
	
	public void allNTuples(List<List<Integer>> result, int[] nums, List<Integer> temp) {
		
		if (temp.size() == nums.length) {
			result.add(new ArrayList<>(temp));
			return;
		}
		
		for (int i = 0; i < nums.length; i++) {
			temp.add(nums[i]);
			allNTuples(result, nums, temp);
			temp.remove(temp.size() - 1);
		}
	}
	
	public static void main(String[] args) {
		int[] nums = {1,2,3};
		EnumerateAllntuples instance = new EnumerateAllntuples();
		List<List<Integer>> result = instance.allNTuples(nums);
		System.out.println(Arrays.toString(result.toArray()));
	}
}
