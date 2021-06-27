package tag.dp;

/**
 * 45. Jump Game II
 * 
 * Given an array of non-negative integers nums, you are initially positioned at the first index of the array.
 *
 * Each element in the array represents your maximum jump length at that position.
 *
 * Your goal is to reach the last index in the minimum number of jumps.
 *
 * You can assume that you can always reach the last index.
 * 
 * Input: nums = [2,3,1,1,4]
 * Output: 2
 * Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * 
 * Input: nums = [2,3,0,1,4]
 * Output: 2
 * 
 * tag: dp
 */
import java.util.Arrays;

public class JumpGameII {

    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, Integer.MAX_VALUE - 1000);
        dp[nums.length - 1] = 0;
        for (int i = nums.length - 2; i >= 0; i--) {
            int step = nums[i];
            while (step > 0) {
                if (i + step < nums.length) {
                    dp[i] = Math.min(dp[i], dp[i + step] + 1);
                }
                step--;
            }
        }

        return dp[0];
    }

    public int jump2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] dp = new int[nums.length];
        Arrays.fill(dp, Integer.MAX_VALUE - 1000);

        for (int i = 0; i < nums.length; i++) {
            int steps = nums[i];
            for (int j = 1; j <= steps; j++) {
                if (i + j < nums.length) {
                    dp[i + j] = Math.min(dp[i + j], dp[i] + 1);
                }
            }
        }

        return dp[dp.length - 1];
    }
}
