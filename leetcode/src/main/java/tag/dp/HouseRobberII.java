package tag.dp;

/**
 * 
 * @author bliu13 Jan 5, 2016
 */
public class HouseRobberII {

	public int rob(int[] nums) {
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
