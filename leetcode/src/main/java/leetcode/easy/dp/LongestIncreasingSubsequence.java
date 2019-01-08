package leetcode.easy.dp;

import java.util.ArrayList;
import java.util.List;

public class LongestIncreasingSubsequence {
	public int lengthOfLIS(int[] nums) {

		if (nums == null || nums.length == 0) {
			return 0;
		}
		List<List<Integer>> lis = new ArrayList<>();
		List<Integer> subseq = new ArrayList<>();
		subseq.add(nums[0]);
		lis.add(subseq);

		for (int i = 1; i < nums.length; i++) {
			subseq = new ArrayList<>();
			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j] && (subseq.size() < lis.get(j).size() + 1)) {
					subseq = new ArrayList<>(lis.get(j));
				}
			}
			subseq.add(nums[i]);
			lis.add(subseq);
		}
				
		return lis.get(lis.size() - 1).size();
	}

	public static void main(String[] args) {
		LongestIncreasingSubsequence instance = new LongestIncreasingSubsequence();
		int[] nums = {10,9,2,5,3,7,101,18};
		System.out.println(instance.lengthOfLIS(nums));
	}
}
