package leetcode.twopointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 	Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

	Note:
	Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a �� b �� c �� d)
	The solution set must not contain duplicate quadruplets.
	    For example, given array S = {1 0 -1 0 -2 2}, and target = 0.

    A solution set is:
    (-1,  0, 0, 1)
    (-2, -1, 1, 2)
    (-2,  0, 0, 2)
 * 
 * @author admin
 *
 */
public class FourSum {

	public List<List<Integer>> fourSum(int[] num, int target) {
		if (num == null || num.length == 0) {
			return new ArrayList<List<Integer>>();
		}
		Arrays.sort(num);
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		for (int i = 0; i < num.length - 2; i++) {
			for (int j = i + 1; j < num.length - 2; j++) {
				int sum = target -num[i] - num[j];
				int start = j + 1;
				int end = num.length - 1;
				while (start < end) {
					if (num[start] + num[end] == sum) {
						List<Integer> temp = new ArrayList<Integer>();
						temp.add(num[i]);
						temp.add(num[j]);
						temp.add(num[start]);
						temp.add(num[end]);
						result.add(temp);
						start++;
						end--;
					} else if (num[start] + num[end] < sum) {
						start++;
					} else {
						end--;
					}
				}
			}
		}
		Set<List<Integer>> ret = new HashSet<List<Integer>>(result);
		result = new ArrayList<List<Integer>>(ret);
		return result;
	}

	public static void main(String[] args) {
		int[] num = { 1, 0, -1, 0, -2, 2 };
		FourSum instance = new FourSum();
		List<List<Integer>> ret = instance.fourSum(num, 0);
		for (List<Integer> list : ret) {
			Integer[] temp = new Integer[list.size()];
			list.toArray(temp);
			System.out.println(Arrays.toString(temp));
		}
	}
}
