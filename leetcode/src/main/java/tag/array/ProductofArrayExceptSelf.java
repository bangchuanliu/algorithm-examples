package tag.array;

public class ProductofArrayExceptSelf {

	public int[] productExceptSelf(int[] nums) {

		int[] result = new int[nums.length];
		result[0] = 1;
		for (int i = 1; i < nums.length; i++) {
			result[i] = nums[i - 1] * result[i - 1];
		}

		int prod = 1;
		for (int i = nums.length - 2; i >= 0; i--) {
			prod = prod * nums[i + 1];
			result[i] *= prod;
		}

		return result;
	}
}