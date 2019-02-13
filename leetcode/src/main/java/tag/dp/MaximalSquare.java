package tag.dp;

public class MaximalSquare {

	public int maximalSquare(char[][] matrix) {
		int m = matrix.length;
		int n = m > 0 ? matrix[0].length : 0;

		int dp[][] = new int[m + 1][n + 1];
		int max = 0;

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (matrix[i][j] == '1') {
					dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i - 1][j - 1], dp[i][j - 1])) + 1;
					max = Math.max(max, dp[i][j]);
				}
			}
		}

		return max * max;
	}

	public static void main(String[] args) {
		MaximalSquare instance = new MaximalSquare();
		char[][] matrix = { { '0', '1' } };
		System.out.println(instance.maximalSquare(matrix));
	}
}
