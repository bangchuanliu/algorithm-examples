package tag.binarysearch;


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

	public boolean search2(int[] nums, int target) {

		int i = 0;
		int j = nums.length - 1;

		while (i <= j) {
			int mid = (i+j) / 2;

			if (nums[mid] == target) {
				return true;
			}

			if (nums[mid] < nums[j]) {
				if (target > nums[mid] && target <= nums[j]) {
					i = mid + 1;
				}else {
					j = mid - 1;
				}
			} else if (nums[mid] > nums[j]) {
				if (target < nums[mid] && target >= nums[i]) {
					j = mid - 1;
				} else {
					i = mid + 1;
				}
			} else {
				j--;
			}
		}

		return false;
	}
}
