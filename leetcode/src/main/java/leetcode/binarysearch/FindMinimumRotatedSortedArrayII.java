package leetcode.binarysearch;

public class FindMinimumRotatedSortedArrayII {
	public int findMin(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}

		int left = 0;
		int right = nums.length - 1;

		while (left < right) {
			int mid = (left + right) / 2;
			if (nums[mid] < nums[right]) {
				right = mid;
			} else if (nums[mid] > nums[right]) {
				left = mid + 1;
			} else {
				right--;
			}
		}

		return nums[right];
	}
}
