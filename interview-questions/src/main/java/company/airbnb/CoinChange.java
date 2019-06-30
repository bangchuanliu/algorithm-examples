package company.airbnb;

import java.util.Arrays;

public class CoinChange {

    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.sort(coins);
        for (int i = 1; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < dp.length; i++) {
            for (int j = coins.length - 1; j >= 0; j--) {
                if (coins[j] <= i && dp[i - coins[j]] < Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }

        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];

    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        System.out.println(coinChange(coins, 11));
        int[] coins2 = {2};
        System.out.println(coinChange(coins2, 3));
    }
}
