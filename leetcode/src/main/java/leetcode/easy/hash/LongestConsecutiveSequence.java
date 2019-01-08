package leetcode.easy.hash;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
	
	public int longestConsecutive(int[] nums) {
		
		if (nums == null || nums.length == 0) {
			return 0;
		}
		
		int max = 0;
		Set<Integer> set = new HashSet<>();
		
		for (int num : nums) {
			set.add(num);
		}
		
		for (int i = 0; i < nums.length; i++) {
			int count = 1;
			int left = nums[i] - 1;
			int right = nums[i] + 1;
			
			while (set.contains(left)) {
				count++;
				set.remove(left);
				left--;
			}
			
			while (set.contains(right)) {
				count++;
				set.remove(right);
				right++;
				
			}
			max = Math.max(count, max);
		}
		
		return max;
	}
}
