package tag.twopointer;


/**
 * 189. Rotate Array
 * 
 * Given an array, rotate the array to the right by k steps, where k is non-negative.
 * 
 * Input: nums = [1,2,3,4,5,6,7], k = 3
 * Output: [5,6,7,1,2,3,4]
 * Explanation:
 * rotate 1 steps to the right: [7,1,2,3,4,5,6]
 * rotate 2 steps to the right: [6,7,1,2,3,4,5]
 * rotate 3 steps to the right: [5,6,7,1,2,3,4]
 * 
 */
public class RotateArray {
	
	public void rotate(int[] nums, int k) {
		if(nums == null || nums.length == 0 || k < 0) return;
		
		k = k % nums.length;

		reverse(nums, 0, nums.length -1);
		reverse(nums, 0, k - 1);
		reverse(nums, k, nums.length -1);
	}
	
	public void reverse(int[] nums, int start,int end){
		while(start < end){
			int temp = nums[end];
			nums[end] = nums[start];
			nums[start] = temp;
			start++;
			end-- ;
		}
	}

}
