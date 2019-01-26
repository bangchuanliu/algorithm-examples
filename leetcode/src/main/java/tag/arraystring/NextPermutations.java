package tag.arraystring;

public class NextPermutations {

	public void nextPermutation(int[] nums) {

		if (nums == null || nums.length == 0) {
			return;
		}
		
		int partitionIndex = nums.length - 2;
		while (partitionIndex >= 0) {
			if (nums[partitionIndex] < nums[partitionIndex+1]) {
				break;
			}
			partitionIndex--;
		}
		
		if(partitionIndex < 0) {
			reverse(nums, 0 , nums.length - 1);
			return;
		}
		
		int changeNumberIndex = nums.length - 1;
		
		while (changeNumberIndex >= 0 && nums[changeNumberIndex] <= nums[partitionIndex]) {
			changeNumberIndex--;
		}
		
		int temp = nums[changeNumberIndex];
		nums[changeNumberIndex] = nums[partitionIndex];
		nums[partitionIndex] = temp;
		
		reverse(nums, partitionIndex + 1, nums.length - 1);
	}
	
	
	
	
	public void reverse(int[] nums, int left, int right) {
		while (left < right) {
			int temp = nums[left];
			nums[left] = nums[right];
			nums[right] = temp;
			left++;
			right--;
		}
	}
}
