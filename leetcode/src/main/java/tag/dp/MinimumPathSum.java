package tag.dp;

/**
 * @author bliu13 Jan 5, 2016
 */
public class MinimumPathSum {

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] sums = new int[m][n];

        sums[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) {
            sums[i][0] = sums[i - 1][0] + grid[i][0];
        }
        for (int j = 1; j < n; j++) {
            sums[0][j] = sums[0][j - 1] + grid[0][j];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                sums[i][j] = Math.min(sums[i][j - 1], sums[i - 1][j]) + grid[i][j];
            }
        }

        return sums[m - 1][n - 1];
    }

    // recursive
    public int minPathSum2(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
            return Integer.MAX_VALUE;
        }
        int l = minPathSum2(grid, i, j - 1);
        int u = minPathSum2(grid, i - 1, j);

        return Math.min(l, u) == Integer.MAX_VALUE ? grid[i][j] : grid[i][j] + Math.min(l, u);
    }

    public static void main(String[] args) {
        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        MinimumPathSum instance = new MinimumPathSum();
        System.out.println(instance.minPathSum2(grid, 2, 2));
    }
}
