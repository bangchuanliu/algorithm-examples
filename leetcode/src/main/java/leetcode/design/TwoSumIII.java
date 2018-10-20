package leetcode.design;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//read heavy
public class TwoSumIII {

	private List<Integer> nums = new ArrayList<>();

	public void addNumber(int num) {
		nums.add(num);
	}

	public boolean findSum(int sum) {
		Set<Integer> numSet = new HashSet<>();
		for (Integer num : nums) {
			if (sum == num || numSet.contains(sum - num)) {
				return true;
			} else {
				numSet.add(num);
			}
		}
		return false;
	}

}

//write heavy
class TwoSum {

	Set<Integer> sums = new HashSet<>();
	List<Integer> nums = new ArrayList<>();

	public void addNumber(int num) {
		for (Integer number : nums) {
			sums.add(number + num);
		}
		nums.add(num);
	}

	public boolean findSum(int num) {
		return sums.contains(num);
	}

}