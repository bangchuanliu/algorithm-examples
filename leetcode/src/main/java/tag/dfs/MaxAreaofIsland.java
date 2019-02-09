package tag.dfs;

public class MaxAreaofIsland {

    int[][] dis = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static int max = 0;
    static int count = 0;
    public int maxAreaOfIsland(int[][] grid) {
        max = 0;
        count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    boolean[][] marked = new boolean[grid.length][grid[0].length];
                    maxAreaOfIsland(grid, i, j, marked);
                    max = Math.max(max, count);
                }
            }
        }

        return max;
    }

    public void maxAreaOfIsland(int[][] grid, int i, int j, boolean[][] marked) {
        count++;
        marked[i][j] = true;
        for (int[] offset : dis) {
            int x = offset[0] + i;
            int y = offset[1] + j;
            if (x >= 0 && x < grid.length && y >= 0 && y < grid[x].length && !marked[x][y] && grid[x][y] == 1) {
                maxAreaOfIsland(grid, x, y, marked);
            }
        }
    }
    
    public static void main(String[] args) {
        int[][] grid = {{1,1,0,1,1},{1,0,0,0,0},{0,0,0,0,1},{1,1,0,1,1}};
//        int[][] grid = {{0,1,0},{1,1,1}};
        MaxAreaofIsland maxAreaofIsland = new MaxAreaofIsland();
        maxAreaofIsland.maxAreaOfIsland(grid);
        System.out.println(max);
    }
}
