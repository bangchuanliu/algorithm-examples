package tag.dp;

public class PaintHouse {

    public int minCost(int[][] costs) {
        if (costs == null || costs.length == 0) {
            return 0;
        }

        int[][] dp = new int[costs.length][costs[0].length];

        for (int i = 0; i < 3; i++) {
            dp[0][i] = costs[0][i];
        }

        for (int i = 1; i < costs.length; i++) {
            dp[i][0] = costs[i][0] + Math.min(dp[i - 1][1], dp[i - 1][2]);
            dp[i][1] = costs[i][1] + Math.min(dp[i - 1][0], dp[i - 1][2]);
            dp[i][2] = costs[i][2] + Math.min(dp[i - 1][1], dp[i - 1][0]);
        }

        int n = costs.length - 1;
        return Math.min(dp[n][0], Math.min(dp[n][1], dp[n][2]));
    }
}
