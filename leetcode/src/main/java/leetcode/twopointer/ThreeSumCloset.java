package leetcode.twopointer;

import java.util.Arrays;

/**
 * 
 * Given an array S of n integers, find three integers in S such that the sum is
 * closest to a given number, target. Return the sum of the three integers. You
 * may assume that each input would have exactly one solution.
 * 
 * For example, given array S = {-1 2 1 -4}, and target = 1.
 * 
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * 
 * @author admin
 *
 */
public class ThreeSumCloset {

	public int threeSumClosest(int[] num, int target) {
		if (num == null || num.length == 0) {
			return Integer.MIN_VALUE;
		}
		int min = Integer.MAX_VALUE;
		int ret = Integer.MIN_VALUE;
		Arrays.sort(num);
		for (int i = 0; i < num.length - 2; i++) {
			int start = i + 1;
			int end = num.length - 1;
			while (start < end) {
				int sum = num[start] + num[end] + num[i];
				int diff = Math.abs(sum - target);
				if (diff == 0) {
					return target;
				}
				if (diff < min) {
					min = diff;
					ret = sum;
				}
				if (sum > target) {
					end--;
				} else {
					start++;
				}
			}
		}
		return ret;
	}

	public static void main(String[] args) {
		int[] num = { -1, 2, 1, 4 };
		int[] num2 = { 1, 1, 1, 0 };
		ThreeSumCloset instance = new ThreeSumCloset();
		System.out.println(instance.threeSumClosest(num, 1));
		System.out.println(instance.threeSumClosest(num2, 100));
	}
}
