package leetcode.easy.diveconquer;

public class BurstBalloons {
	public int maxCoins(int[] nums) {

		if (nums == null || nums.length == 0) {
			return 0;
		}

		int n = nums.length;
		int[] coins = new int[n + 2];
		coins[0] = 1;
		coins[n + 1] = 1;

		System.arraycopy(nums, 0, coins, 1, nums.length);

		int[][] maxCoins = new int[coins.length][coins.length];

		return burst(maxCoins, coins, 0, coins.length - 1);
	}

	public int burst(int[][] maxCoins, int[] coins, int left, int right) {
		if (left + 1 ==  right) {
			return 0;
		}

		if (maxCoins[left][right] > 0) {
			return maxCoins[left][right];
		}

		int maxCoin = 0;

		for (int i = left + 1; i < right; i++) {
			maxCoin = Math.max(maxCoin, coins[left] * coins[i] * coins[right] + burst(maxCoins, coins, left, i) 
					+ burst(maxCoins, coins, i, right));
		}
		
		maxCoins[left][right] = maxCoin;
		return maxCoins[left][right];
	}
	
	public static void main(String[] args) {
		BurstBalloons instance = new BurstBalloons();
		int[] nums = {3,1,5,8};
		System.out.println(instance.maxCoins(nums));
	}
}
