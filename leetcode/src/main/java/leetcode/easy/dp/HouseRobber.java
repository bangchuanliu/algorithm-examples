package leetcode.easy.dp;

public class HouseRobber {
	public int rob(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int be4_yesterday = 0, yesterday = 0, today = 0;
		for (int i = 0; i < nums.length; i++) {
			today = Math.max(be4_yesterday + nums[i], yesterday);
			be4_yesterday = yesterday;
			yesterday = today;
		}
		return today;
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

		int[] result = new int[nums.length];
		result[0] = nums[0];
		result[1] = Math.max(nums[0], nums[1]);

		for (int i = 2; i < nums.length; i++) {
			result[i] = Math.max(result[i - 1], result[i - 2] + nums[i]);
		}

		return result[result.length - 1];
	}

	public static void main(String[] args) {
		HouseRobber ins = new HouseRobber();
		int[] nums = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		System.out.println(ins.rob2(nums));
	}
}
