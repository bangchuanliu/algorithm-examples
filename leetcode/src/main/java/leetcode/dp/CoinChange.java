package leetcode.dp;

import java.util.Arrays;

/**
 * 
 * @author bliu13 Jan 5, 2016
 */
public class CoinChange {

	
	// dp[i + coins[j]] = Math.min(dp[i + coins[j]], dp[i] + 1)
	
	public int coinChange(int[] coins, int amount) {
		if (coins == null || coins.length == 0 || amount <= 0) {
			return 0;
		}

		int[] sum = new int[amount+1];
		Arrays.fill(sum, Integer.MAX_VALUE);
		sum[0] = 0;
		
		for (int coin : coins) {
			for (int i = coin; i <= amount; i++) {
				if (sum[i - coin] != Integer.MAX_VALUE) {
					sum[i] = Math.min(sum[i], sum[i-coin] + 1);
				}
			}
		}

		return sum[amount] == Integer.MAX_VALUE ? -1 : sum[amount];
	}
	
	public static void main(String[] args) {
		int[] coins = { 186, 419, 83, 408 };
		int amount = 6249;

		CoinChange instance = new CoinChange();
		System.out.println(instance.coinChange(coins, amount));
	}
}
