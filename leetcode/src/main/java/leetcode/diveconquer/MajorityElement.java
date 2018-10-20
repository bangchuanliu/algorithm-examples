package leetcode.diveconquer;

import java.util.Arrays;

public class MajorityElement {

	/**
	 * sort
	 * @param num
	 * @return
	 */
	public static int majorityElement2(int[] nums) {
		if(null == nums || nums.length <=0){
			return -1;
		}
		Arrays.sort(nums);
		return nums[nums.length / 2];
	}
	
	/**
	 * divide and conquer
	 * 
	 * @param num
	 * @return
	 */
	public static int majorityElement(int[] num) {
		if(num == null || num.length <= 0){
			return -1;
		}
		int candidate = 0;
		int nTimes = 0;
		for(int i = 0;i<num.length;i++){
			if(nTimes == 0 ){
				candidate = num[i];
				nTimes++;
			}else{
				if(candidate == num[i]){
					nTimes++;
				}else{
					nTimes--;
				}
			}
		}
		return candidate;
	}
	
	public static void main(String[] args){
		int[] num = {3,3,4};
		System.out.println(majorityElement(num));
		System.out.println(majorityElement2(num));
	}
	
}
