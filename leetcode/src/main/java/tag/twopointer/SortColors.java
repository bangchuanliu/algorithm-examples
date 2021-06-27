package tag.twopointer;

import java.util.Arrays;

/**
 * 75. Sort Colors
 * 
 * Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
 *
 * We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
 *
 * You must solve this problem without using the library's sort function.
 * 
 * Input: nums = [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 * 
 * Input: nums = [2,0,1]
 * Output: [0,1,2]
 */
public class SortColors {

	public void sortColors(int[] nums) {
		if (nums == null || nums.length == 0) return;
		
		int redIndex = 0;
		int blueIndex = nums.length - 1;
		int i = 0;
		
		while (i <= blueIndex) {
			if (nums[i] == 2) {
				swap(nums, i, blueIndex);
				blueIndex--;
			} else if (nums[i] == 0){
				swap(nums, i, redIndex);
				i++;
				redIndex++;
			} else {
				i++;
			}
		}
	}

	public void sortColors2(int[] nums) {
		if (nums == null || nums.length == 0) {
			return;
		}

		int i = 0;
		int j = nums.length - 1;
		int k = 0;

		while (k <= j) {
			if (nums[k] == 0 && k != i) {
				int temp = nums[i];
				nums[i] = 0;
				nums[k] = temp;
				i++;
			} else if (nums[k] == 2) {
				int temp = nums[j];
				nums[j] = 2;
				nums[k] = temp;
				j--;
			} else {
				k++;
			}
		}
	}
	
	public void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	public static void main(String[] args) {
		SortColors instance = new SortColors();
		int[] nums = {0};
		instance.sortColors(nums);
		System.out.println(Arrays.toString(nums));
	}
}
