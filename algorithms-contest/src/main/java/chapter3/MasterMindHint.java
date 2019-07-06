package chapter3;

import java.util.Arrays;

public class MasterMindHint {

    public static int[][] guessMismatch(int[][] grid) {
        if (grid == null || grid.length <= 1) {
            return null;
        }

        int[] ans = grid[0];

        int[][] result = new int[grid.length - 1][2];

        for (int i = 1; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == ans[j]) {
                    result[i - 1][0]++;
                }
            }
            for (int j = 1; j <= 9; j++) {
                int c1 = 0;
                int c2 = 0;
                for (int k = 0; k < grid[i].length; k++) {
                    if (ans[k] == j) c1++;
                    if (grid[i][k] == j) c2++;
                }
                result[i - 1][1] += Math.min(c1, c2);
            }
        }

        for (int i = 0; i < result.length; i++) {
            result[i][1] -= result[i][0];
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] grid = {{1, 3, 5, 5}, {1, 1, 2, 3}, {4, 3, 3, 5}, {6, 5, 5, 1}, {6, 1, 3, 5}, {1, 3, 5, 5}};
        System.out.println(Arrays.deepToString(guessMismatch(grid)));

        int[][] grid2 = {{1, 2, 2, 2, 4, 5, 6, 6, 6, 9}, {1, 2, 3, 4, 5, 6, 7, 8, 9, 1}, {1, 1, 2, 2, 3, 3, 4, 4, 5, 5}, {1, 2, 1, 3, 1, 5, 1, 6, 1, 9}, {1, 2, 2, 5, 5, 5, 6, 6, 6, 7}};
        System.out.println(Arrays.deepToString(guessMismatch(grid2)));
    }
}
