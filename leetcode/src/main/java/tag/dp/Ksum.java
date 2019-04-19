package tag.dp;

public class Ksum {

    public int  kSum(int A[], int k, int target) {
        int[][][] dp = new int[A.length+1][k+1][target+1];
        
        for (int i = 0; i <= A.length; i++) {
            dp[i][0][0] = 1;
        }
        
        for (int i = 1; i <= A.length; i++) {
            for (int j = 1; j <= k && j <= i; j++) {
                for (int t = 1; t <= target; t++) {
                    if (t >= A[i-1]) {
                        dp[i][j][t] = dp[i-1][j-1][t - A[i-1]];
                    }
                    dp[i][j][t] += dp[i-1][j][t];
                }
            }
        }
        
        return dp[A.length][k][target];
    }
}
