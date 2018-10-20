package leetcode.bit;

public class SingleNumber {

	public int singleNumber(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int num = nums[0];
		for (int i = 1; i < nums.length; i++) {
			num = num ^ nums[i];
		}
		return num;
	}

	public static void main(String[] args) {
		int[] A = { 1, 1, 1, 2 };
		System.out.println(new SingleNumber().singleNumber(A));
	}
}
