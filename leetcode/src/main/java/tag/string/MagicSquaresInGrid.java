package tag.string;

import java.util.HashSet;
import java.util.Set;

public class MagicSquaresInGrid {
    public static int  numMagicSquaresInside(int[][] grid) {
        int num = 0;

        for (int i = 0; i + 2 < grid.length; i++) {
            for (int j = 0; j + 2 < grid[0].length; j++) {
                if (isMagicSquare(grid, i, j)) {
                    num++;
                }
            }
        }

        return num;
    }

    private static boolean isMagicSquare(int[][] grid, int m, int n) {
        Set<Integer> set = new HashSet<>();
        set.add(1);set.add(2);set.add(3);set.add(4);set.add(5);set.add(6);set.add(7);
        set.add(8);set.add(9);
        for (int i = m; i < grid.length && i < m + 3; i++) {
            int sum = 0;
            for (int j = n; j < grid[0].length && j < n + 3; j++) {
                sum += grid[i][j];
                set.remove(grid[i][j]);
            }
            if (sum != 15) {
                return false;
            }
        }

        if (set.size() != 0) {
            return false;
        }

        for (int i = n; i < grid[0].length && i < n + 3; i++) {
            int sum = 0;
            for (int j = m; j < grid.length && j < m + 3; j++) {
                sum += grid[j][i];
            }
            if (sum != 15) {
                return false;
            }
        }

        if (grid[m][n] + grid[m + 1][n + 1] + grid[m + 2][n + 2] != 15) {
            return false;
        }

        if (grid[m + 2][n] + grid[m + 1][n + 1] + grid[m][n + 2] != 15) {
            return false;
        }

        return true;
    }
    
    public static void main(String[] args) {
        int[][] grid = {{3,2,9,2,7},{6,1,8,4,2},{7,5,3,2,7},{2,9,4,9,6},{4,3,8,2,5}};
        System.out.println(numMagicSquaresInside(grid));
    }
}
