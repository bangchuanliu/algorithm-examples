package tag.dfs;

import java.util.Arrays;

public class ZeroOneMatrix {

    public int[][] updateMatrix(int[][] matrix) {
        int[][] result = new int[matrix.length][matrix[0].length];
        boolean[][] marked;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                marked = new boolean[matrix.length][matrix[0].length];
                result[i][j] = dist(matrix, i, j, 0, marked);
            }
        }

        return result;
    }

    int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int dist(int[][] matrix, int i, int j, int dis, boolean[][] marked) {
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || marked[i][j]) {
            return Integer.MAX_VALUE;
        }
        if (matrix[i][j] == 0) {
            return dis;
        }
        marked[i][j] = true;

        int min = Integer.MAX_VALUE;
        for (int[] d : dir) {
            int temp = dist(matrix, i + d[0], j + d[1], dis + 1, marked);
            min = Math.min(min, temp);
        }
        marked[i][j] = false;
        return min == Integer.MAX_VALUE ? Integer.MAX_VALUE : min;
    }

    /***
     * DP
     *
     * @param args
     */
    public int[][] updateMatrix2(int[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                if (matrix[i][j] == 1) {
                    dp[i][j] = Integer.MAX_VALUE - 10000;
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 1) {
                    if (i > 0) {
                        dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + 1);
                    }
                    if (j > 0) {
                        dp[i][j] = Math.min(dp[i][j], dp[i][j - 1]+ 1);
                    }
                }
            }
        }

        for (int i = matrix.length - 1; i >= 0; i--) {
            for (int j = matrix[0].length - 1; j >= 0; j--) {
                if (matrix[i][j] == 1) {
                    if (i < matrix.length - 1) {
                        dp[i][j] = Math.min(dp[i][j], dp[i + 1][j] + 1);
                    }
                    if (j < matrix[0].length - 1) {
                        dp[i][j] = Math.min(dp[i][j], dp[i][j + 1] + 1);
                    }
                }
            }
        }
        return dp;
    }

    public static void main(String[] args) {
        ZeroOneMatrix zeroOneMatrix = new ZeroOneMatrix();
        int[][] matrix = {{0, 0, 0}, {0, 1, 0}, {1, 1, 1}};
        System.out.println(Arrays.deepToString(zeroOneMatrix.updateMatrix(matrix)));
    }
}
