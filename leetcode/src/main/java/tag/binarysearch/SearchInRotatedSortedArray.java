package tag.binarysearch;

/**
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 *
 *  (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 *
 *  You are given a target value to search. If found in the array return its index, otherwise return -1.
 *
 *  You may assume no duplicate exists in the array.
 * 
 * @author bliu13 Jan 11, 2016
 */
public class SearchInRotatedSortedArray {

	public int search(int[] nums, int target) {
		if (nums == null || nums.length == 0) {
			return -1;
		}

		int i = 0;
		int j = nums.length - 1;

		while (i <= j) {
			// mid is possibly equal to left in this way of compute
			// in case of two elements [3, 1], mid = (0 + 1) / 2
			int mid = (j+i) / 2;

			if (nums[mid] == target) {
				return mid;
			}

			if (nums[i] <= nums[mid]) { // need include nums[mid] == nums[left] case
				if (target > nums[mid] && target <= nums[j]) {
					i = mid + 1;
				} else {
					j = mid - 1;
				}
			} else {
				if (target >= nums[i] && target < nums[mid]) {
					j = mid - 1;
				} else {
					i = mid + 1;
				}
			}
		}

		return -1;
	}
}
