package leetcode.twopointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array S of n integers, are there elements a, b, c in S such that a +
 * b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 * 
 * Note: Elements in a triplet (a,b,c) must be in non-descending order. (ie, a
 * <= b <= c) The solution set must not contain duplicate triplets. For example,
 * given array S = {-1 0 1 2 -1 -4},
 * 
 * A solution set is: (-1, 0, 1) (-1, -1, 2)
 * 
 * @author admin
 *
 */
public class ThreeSum {

	public List<List<Integer>> threeSum(int[] num) {
		if (num == null || num.length == 0) {
			return new ArrayList<List<Integer>>();
		}
		Arrays.sort(num);
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		for (int i = 0; i < num.length - 2; i++) {
			if (i > 0 && num[i] == num[i - 1]) {
				continue;
			}
			int target = -num[i];
			int start = i + 1;
			int end = num.length - 1;
			while (start < end) {
				if (num[start] + num[end] == target) {
					List<Integer> temp = new ArrayList<Integer>();
					temp.add(num[i]);
					temp.add(num[start]);
					temp.add(num[end]);
					result.add(temp);
					start++;
					end--;
					while (start < end && num[start] == num[start - 1]) {
						start++;
					}
					while (start < end && num[end] == num[end + 1]) {
						end--;
					}
				} else if (num[start] + num[end] < target) {
					start++;
				} else {
					end--;
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		ThreeSum instance = new ThreeSum();
		int[] num = { 7, -1, 14, -12, -8, 7, 2, -15, 8, 8, -8, -14, -4, -5, 7, 9, 11, -4, -15, -6, 1, -14, 4, 3, 10, -5,
				2, 1, 6, 11, 2, -2, -5, -7, -6, 2, -15, 11, -6, 8, -4, 2, 1, -1, 4, -6, -15, 1, 5, -15, 10, 14, 9, -8,
				-6, 4, -6, 11, 12, -15, 7, -1, -9, 9, -1, 0, -4, -1, -12, -2, 14, -9, 7, 0, -3, -4, 1, -2, 12, 14, -10,
				0, 5, 14, -1, 14, 3, 8, 10, -8, 8, -5, -2, 6, -11, 12, 13, -7, -12, 8, 6, -13, 14, -2, -5, -11, 1, 3,
				-6 };
		int[] num2 = { -2, 0, 0, 2, 2 };
		List<List<Integer>> ret = instance.threeSum(num);
		for (List<Integer> list : ret) {
			Integer[] temp = new Integer[list.size()];
			list.toArray(temp);
			System.out.println(Arrays.toString(temp));
		}
		ret.clear();
		ret = instance.threeSum(num2);
		for (List<Integer> list : ret) {
			Integer[] temp = new Integer[list.size()];
			list.toArray(temp);
			System.out.println(Arrays.toString(temp));
		}
	}
}
