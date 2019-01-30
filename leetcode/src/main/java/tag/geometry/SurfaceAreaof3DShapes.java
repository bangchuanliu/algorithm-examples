package tag.geometry;

public class SurfaceAreaof3DShapes {
    public int surfaceArea(int[][] grid) {
        int sur = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != 0) {
                    int v = grid[i][j];
                    sur += grid[i][j] * 6 - (grid[i][j] - 1) * 2;
                    int left = Math.min(neighbour(grid, i, j - 1), v);
                    int right = Math.min(neighbour(grid, i, j + 1), v);
                    int up = Math.min(neighbour(grid, i - 1, j), v);
                    int bottom = Math.min(neighbour(grid, i + 1, j), v);
                    sur = sur - left - right - up - bottom;
                }

            }
        }
        return sur;
    }

    public int neighbour(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length) {
            return 0;
        }
        return grid[i][j];
    }

}
