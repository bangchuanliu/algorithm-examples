package leetcode.easy.twopointer;

public class MinimumSizeSubarraySum {

	/**
	 * o (n) slide window
	 * 
	 * @param s
	 * @param nums
	 * @return
	 */
	public int minSubArrayLen(int s, int[] nums) {

		if (nums == null || nums.length == 0 || s <= 0) {
			return 0;
		}

		int sum = 0;
		int min = Integer.MAX_VALUE;
		int start = 0;
		int end = 0;

		while (end < nums.length) {
			while (sum < s && end < nums.length) {
				sum += nums[end];
				end++;
			}
			while (sum >= s && start <= end) {
				min = Math.min(min, end - start);
				sum -= nums[start];
				start++;
			}
		}

		return min == Integer.MAX_VALUE ? 0 : min;
	}
	
	
	/**
	 * binary search 
	 * 
	 * o (nlogn)
	 * 
	 * @param s
	 * @param nums
	 * @return
	 */
	public int minSubArrayLen2(int s, int[] nums) {
		
		if (nums == null || nums.length == 0 || s <= 0) {
			return 0;
		}
		
		return minSubArrayLen2(s, nums, 0, nums.length - 1);
	}
	
	public int minSubArrayLen2(int s, int[] nums, int low, int high) {
		
		if (low > high) {
			return 0;
		}
		
		int mid = (low + high) / 2;
		
		if (nums[mid] >= s) {
			return 1;
		}
		
		int left = minSubArrayLen2(s, nums, low, mid - 1);
		int right = minSubArrayLen2(s, nums, mid+1, high);
		
		int sum = 0;
		int front = mid;
		int end = mid;
		
		while (sum < s && front >= low && end <= high) {
			sum += nums[front];
			sum += nums[end];
		}
		
		return Math.min(end-front, Math.min(left, right));
	}
	
	 public int minSubArrayLen3(int s, int[] nums) {
	        if (nums == null || nums.length == 0) {
	            return 0;
	        }
	        
	        int minLen = 0;
	        int sum = 0;
	        
	        int start = 0;
	        int end = 0;
	        while (end < nums.length) {
	           sum += nums[end]; 
	           while (start <= end && sum >= s) {
	               minLen = Math.min(minLen, end - start + 1);
	               sum -= nums[start];
	               start++;
	           }
	           end++;
	        }
	        
	        return minLen;
	    }
	 
	 public static void main(String[] args) {
		 MinimumSizeSubarraySum instance = new MinimumSizeSubarraySum();
		 int[] nums = {1,4,4};
		 System.out.println(instance.minSubArrayLen3(4, nums));
	 }
	
}
