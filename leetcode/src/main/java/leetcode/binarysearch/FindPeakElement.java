package leetcode.binarysearch;

public class FindPeakElement {
	public int findPeak(int[] nums) {
		if (nums == null || nums.length <= 1) {
			return 0;
		}
		if (nums[0] > nums[1]) {
			return 0;
		}
		if (nums[nums.length - 1] > nums[nums.length - 2]) {
			return nums.length - 1;
		}
		int left = 1;
		int right = nums.length - 2;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
				return mid;
			} else if (nums[mid] < nums[mid - 1]) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 1, 2, 3, 1 };
		FindPeakElement instance = new FindPeakElement();
		System.out.println(instance.findPeak(nums));
	}
}
