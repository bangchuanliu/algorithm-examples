package tag.dp;

/**
 * 
 * @author bliu13 Jan 5, 2016
 */
public class HouseRobberII {

	public int rob(int[] nums) {

		if (nums == null || nums.length == 0) {
			return 0;
		}

		int n = nums.length;

		if (n == 1) {
			return nums[0];
		}

		if (n == 2) {
			return Math.max(nums[0], nums[1]);
		}

		int[] result = new int[n];
		result[0] = 0;
		result[1] = nums[0];

		for (int i = 2; i < n; i++) {
			result[i] = Math.max(result[i - 1], result[i - 2] + nums[i - 1]);
		}

		int[] result2 = new int[n];
		result2[0] = 0;
		result2[1] = nums[1];

		for (int i = 2; i < n; i++) {
			result2[i] = Math.max(result2[i - 1], result2[i - 2] + nums[i]);
		}

		return Math.max(result[n - 1], result2[n - 1]);
	}

	public int rob2(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}

		if (nums.length == 1) {
			return nums[0];
		}

		if (nums.length == 2) {
			return Math.max(nums[0], nums[1]);
		}

		// from 1 to nums.length - 1
		int beforeYesterday = 0;
		int yesterday = 0;
		int today1 = 0;
		for (int i = 0; i < nums.length - 1; i++) {
			today1 = Math.max(yesterday, nums[i] + beforeYesterday);
			beforeYesterday = yesterday;
			yesterday = today1;
		}

		// from 2 to nums.length
		beforeYesterday = 0;
		yesterday = 0;
		int today2 = 0;
		for (int i = 1; i < nums.length; i++) {
			today2 = Math.max(yesterday, nums[i] + beforeYesterday);
			beforeYesterday = yesterday;
			yesterday = today2;
		}

		return Math.max(today1, today2);
	}

}
