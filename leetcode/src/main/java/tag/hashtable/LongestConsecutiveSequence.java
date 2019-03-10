package tag.hashtable;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
	
	public int longestConsecutive(int[] nums) {
		int max = 0;
		Set<Integer> set = new HashSet<>();
		
		for (int num : nums) {
			set.add(num);
		}
		
		for (int i = 0; i < nums.length; i++) {
		    if (!set.contains(nums[i] - 1)) {
		        int count = 1;
		        int curNum = nums[i]+1;
		        while (set.contains(curNum)) {
		            count++;
                    curNum++;
                }
                max = Math.max(max, count);
            }
        }
		
		return max;
	}
}
