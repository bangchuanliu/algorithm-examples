package leetcode.arraystring;


/**
 * 
 * @author BangChuan Liu 
 * @date   2015
 * @Contact liubangchuan1100@gmail.com
 */
public class RotateArray {
	public void rotate(int[] nums, int k) {
		if(nums == null || nums.length == 0 || k < 0){
			return;
		}
		int[] result = new int[nums.length];
		for(int i = 0;i<nums.length;i++){
			int j = (i + k)%nums.length;
			result[j] = nums[i];
		}
		System.arraycopy(result, 0, nums, 0, result.length);
	}
	

	
	 public void rotate3(int[] nums, int k) {
	        
	        if (nums == null || nums.length == 0 || k < 0) {
	            return;
	        }
	        
	        int[] nums2 = new int[nums.length];
	        if (k > nums.length) {
	            k = k % nums.length;
	        }
	        
	        int len = nums.length;
	        
	        for (int i = 0; i < nums2.length; i++) {
	            nums2[i] = nums[(len-k+i) % len];
	        }
	        
	        System.arraycopy(nums2, 0, nums, 0 , len);
	    }
	
	public void rotate2(int[] nums, int k) {
		if(nums == null || nums.length == 0 || k < 0){
			return;
		}
		if(k>nums.length){
			k = k % nums.length;
		}
		int len = nums.length - k;
		reverse(nums, 0, len-1);
		reverse(nums,len,nums.length - 1);
		reverse(nums,0,nums.length - 1);
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
