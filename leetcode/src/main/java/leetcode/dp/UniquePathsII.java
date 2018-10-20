package leetcode.dp;

public class UniquePathsII {

	public int uniquePathsWithObstacles(int[][] obstacleGrid) {

		if (obstacleGrid == null || obstacleGrid.length == 0) {
			return 0;
		}

		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;

		int[][] result = new int[m][n];

		for (int i = 0; i < m; i++) {
			if (obstacleGrid[i][0] == 1) {
				break;
			}
			result[i][0] = 1;
		}

		for (int j = 0; j < n; j++) {
			if (obstacleGrid[0][j] == 1) {
				break;
			}
			result[0][j] = 1;
		}

		return uniquePaths(m, n, result, obstacleGrid);
	}

	public int uniquePaths(int m, int n, int[][] result, int[][] obstacleGrid) {
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (obstacleGrid[i][j] == 1) {
					result[i][j] = 0;
				} else {
					result[i][j] = result[i - 1][j] + result[i][j - 1];
				}
			}
		}

		return result[m - 1][n - 1];
	}
}
