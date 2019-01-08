package leetcode.easy.dp;

import java.util.Arrays;

public class PerfectSquares {

	public int numSquares(int n) {
		if (n <= 0) {
			return 0;
		}

		int[] result = new int[n + 1];
		Arrays.fill(result, Integer.MAX_VALUE);

		for (int i = 1; i * i <= n; i++) {
			result[i * i] = 1;
		}

		for (int i = 1; i < n; i++) {
			for (int j = 1; i + j * j <= n; j++) {
				result[i + j * j] = Math.min(result[i + j * j], result[i] + 1);
			}
		}

		return result[n];
	}
}
