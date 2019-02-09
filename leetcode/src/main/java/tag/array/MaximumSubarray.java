package tag.array;

public class MaximumSubarray {
    
    public int maxSubArray(int[] nums) {
        int[] sums = new int[nums.length+1];
        
        for (int i = 0; i < nums.length; i++) {
            sums[i+1] = sums[i] + nums[i];
        }

        int min = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < sums.length; i++) {
            max = Math.max(max, sums[i] - min);
            min = Math.min(min, sums[i]);
        }
        
        return max;
    }
    
    public static void main(String[] args) {
        MaximumSubarray instance = new MaximumSubarray();
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(instance.maxSubArray(nums));
    }
}
