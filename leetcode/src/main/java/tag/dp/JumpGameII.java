package tag.dp;

import java.util.Arrays;

public class JumpGameII {
    
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, Integer.MAX_VALUE-1000);
        dp[nums.length - 1] = 0;
        for (int i = nums.length - 2; i >= 0; i--) {
            int step = nums[i];
            while (step > 0) {
                if (i + step < nums.length) {
                    dp[i] = Math.min(dp[i], dp[i+step]+1);    
                }
                step--;
            }
        }
        
        return dp[0];
    }
}
