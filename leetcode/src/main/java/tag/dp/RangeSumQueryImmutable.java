package tag.dp;

public class RangeSumQueryImmutable {
	private int[] nums;
	private int[] sums;

	public RangeSumQueryImmutable(int[] nums) {
		this.nums = nums;
		if (nums != null && nums.length != 0) {
			sums = new int[nums.length];
			sums[0] = nums[0];
			for (int i = 1; i < nums.length; i++) {
				sums[i] = nums[i] + sums[i-1];
			}
		}
	}

	public int sumRange(int i, int j) {
		if (nums == null || nums.length == 0) {
			return 0;
		}

		if (i < 0) {
			i = 0;
		}

		if (j > nums.length - 1) {
			j = nums.length - 1;
		}

		return i == 0 ? sums[j] : sums[j] - sums[i-1];
	}
}
