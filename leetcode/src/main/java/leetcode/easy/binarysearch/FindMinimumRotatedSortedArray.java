package leetcode.easy.binarysearch;

public class FindMinimumRotatedSortedArray {

	public int findMin(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}

		int left = 0;
		int right = nums.length - 1;

		while (left < right) {
			int mid = (left + right) / 2;
			if (nums[mid] < nums[right]) {
				right = mid;
			} else {
				left = mid + 1;
			}
		}

		return nums[right];
	}

	public static void main(String[] args) {
		int[] num1 = { 2, 4, 5, 6, 7, 0, 1 };
		int[] num2 = { 0, 1, 2, 3, 4, 5, 6 };
		int[] num3 = { 5, 1, 2, 3, 4 };
		int[] num4 = { 1, 2, 3, 4, 5 };
		int[] num5 = { 6, 1, 2, 3, 4, 5 };
		FindMinimumRotatedSortedArray instance = new FindMinimumRotatedSortedArray();
		System.out.println(instance.findMin(num1));
		System.out.println(instance.findMin(num2));
		System.out.println(instance.findMin(num3));
		System.out.println(instance.findMin(num4));
		// System.out.println(instance.findMin2(num5));
	}
}
