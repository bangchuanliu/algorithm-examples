package pearls8;

public class MaximumSubArray {

    public static void main(String[] args) {
        int[] nums = {31, -41, 59, 26, -53, 58, 97, -93, -23, 84};
        System.out.println(maxSum(nums));
    }


    public static int maxSum(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int sum = 0;
        int max = Integer.MIN_VALUE;

        for (int num : nums) {
            sum = Math.max(sum + num, num);
            max = Math.max(max, sum);
        }

        return max;
    }
} 
