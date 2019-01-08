package leetcode.easy.binarysearch;


/**
 * 
 * @author bliu13 Jan 11, 2016
 */
public class SearchinRotatedSortedArrayII {
	
	public boolean search(int[] nums, int target) {
		if (nums == null || nums.length == 0) {
			return false;
		}

		int left = 0;
		int right = nums.length - 1;

		while (left <= right) {
			int mid = right - (right - left) / 2;

			if (nums[mid] == target) {
				return true;
			}
			
			if (nums[left] < nums[mid]) {
				if (target < nums[mid] && target >= nums[left]) {
					right = mid - 1;
				} else {
					left = mid + 1;
				}
			} else if (nums[left] > nums[mid]){
				if (nums[mid] < target && target <= nums[right]) {
					left = mid + 1;
				} else {
					right = mid - 1;
				}
			} else {
				left++;
			}
		}

		return false;
	}
}
