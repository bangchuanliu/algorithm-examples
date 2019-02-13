package tag.dp;

/**
 * 
 * @author bliu13 Jan 6, 2016
 */
public class UniquePaths {
	public int uniquePaths(int m, int n) {
		int[][] result = new int[m][n];
		
		for (int i = 0; i < m; i++) {
			result[i][0] = 1;
		}
		
		for (int j = 0; j < n; j++) {
			result[0][j] = 1;
		}
		
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				result[i][j] = result[i-1][j] + result[i][j-1];
			}
		}
		
		return result[m-1][n-1];
	}

	/**
	 * recursive
	 */
	public int uniquePaths2(int m, int n) {
		if (m == 1 || n == 1) {
			return 1;
		}
		return uniquePaths2(m-1,n) + uniquePaths(m,n-1);
	}

	
	public static void main(String[] args) {
		UniquePaths instance = new UniquePaths();
		System.out.println(instance.uniquePaths2(7, 3));
	}
}
