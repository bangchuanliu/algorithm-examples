package leetcode.easy.bit;

public class SingleNumberII {

	public int singleNumber(int[] nums) {

		if (nums == null || nums.length == 0) {
			return 0;
		}

		int result = 0;

		for (int i = 0; i < 32; i++) {
			int count = 0;

			for (int num : nums) {
				if (isBit1(num, i)) {
				count++;
			}
		}

			result |= (count % 3) << i;
		}

		return result;
	}

	public boolean isBit1(int num, int index) {
		return ((num >> index) & 1) == 1;
	}
}
