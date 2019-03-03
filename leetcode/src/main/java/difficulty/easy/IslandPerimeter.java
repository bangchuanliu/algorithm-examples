package difficulty.easy;

public class IslandPerimeter {

    public int islandPerimeter(int[][] grid) {
        int sum = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    sum += numOfOne(grid, i, j);
                }
            }
        }

        return sum;

    }

    int[][] dis = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int numOfOne(int[][] grid, int i, int j) {
        int count = 4;
        for (int[] d : dis) {
            int x = i + d[0];
            int y = j + d[1];

            if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == 1) {
                count--;
            }
        }

        return count;
    }
}
