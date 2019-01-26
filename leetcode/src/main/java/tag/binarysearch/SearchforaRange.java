package tag.binarysearch;

/**
 * 
 * @author bliu13 Jan 10, 2016
 */
public class SearchforaRange {

	public int[] searchRange(int[] nums, int target) {
		if (nums == null || nums.length == 0) {
			return new int[0];
		}

		int start = 0;
		int end = nums.length - 1;
		int[] result = new int[2];
		result[0] = -1;
		result[1] = -1;
		while (start <= end) {
			int mid = end - (end - start) / 2;

			if (nums[mid] > target) {
				end = mid - 1;
			} else if (nums[mid] < target) {
				start = mid + 1;
			} else {
				result[1] = mid;
				start = mid + 1;
			}
		}
		
		start = 0;
		end = nums.length - 1;
		while (start <= end) {
			int mid = end - (end - start) / 2;

			if (nums[mid] > target) {
				end = mid - 1;
			} else if (nums[mid] < target) {
				start = mid + 1;
			} else {
				result[0] = mid;
				end = mid - 1;
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		int[] nums = new int[100000000];
		SearchforaRange instance = new SearchforaRange();
		long start = System.currentTimeMillis();
		instance.searchRange(nums, 0);
		System.out.println(System.currentTimeMillis() - start);
		start = System.currentTimeMillis();
		System.out.println(System.currentTimeMillis() - start);
	}
}
