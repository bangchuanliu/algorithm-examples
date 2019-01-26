package tag.twopointer;

import java.util.Arrays;

public class SortColors {

	/**
	 * Counting sort
	 * 
	 * @param nums
	 */
	public void sortColors(int[] nums) {

		if (nums == null || nums.length == 0) {
			return;
		}

		int[] index = new int[3];

		for (int num : nums) {
			index[num]++;
		}

		for (int i = 0; i < nums.length; i++) {
			if (index[0] > 0) {
				nums[i] = 0;
				index[0]--;
				continue;
			}

			if (index[1] > 0) {
				nums[i] = 1;
				index[1]--;
				continue;
			}
			nums[i] = 2;
		}

	}

	/**
	 * two pointers sort
	 * 
	 * @param nums
	 */
	public void sortColors2(int[] nums) {
		if (nums == null || nums.length == 0) {
			return;
		}
		
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
	
	public void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	public static void main(String[] args) {
		SortColors instance = new SortColors();
		int[] nums = {1,0};
		instance.sortColors2(nums);
		System.out.println(Arrays.toString(nums));
	}
}
