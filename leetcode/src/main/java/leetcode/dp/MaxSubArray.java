package leetcode.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Find the contiguous subarray within an array (containing at least one number)
 * which has the largest sum.
 * 
 * For example, given the array [−2,1,−3,4,−1,2,1,−5,4], the contiguous subarray
 * [4,−1,2,1] has the largest sum = 6.
 * 
 * @author admin
 *
 */
public class MaxSubArray {

	public int maxSubArray(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}

		int sum = 0;
		int max = Integer.MIN_VALUE;

		for (int num : nums) {
			sum = Math.max(sum + num, num);
			max = Math.max(max, sum);
		}

		return max;
	}

	public static void main(String[] args) {
		MaxSubArray instance = new MaxSubArray();
		Integer[] arr = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		List<Integer> nums = new ArrayList<Integer>(Arrays.asList(arr));
	}
}
