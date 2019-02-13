package tag.dp;

import java.util.Arrays;

public class IntegerBreak {
    
    public int integerBreak(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, 1);
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j < i ; j++) {
                int temp = Math.max((i-j) * j, dp[i-j] * j);
                dp[i] = Math.max(dp[i], temp);
            }
        }
        
        return dp[n];
    }
    
    public static void main(String[] args) {
        System.out.println(new IntegerBreak().integerBreak(2));
    }
}
