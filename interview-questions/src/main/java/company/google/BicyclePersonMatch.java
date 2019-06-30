package company.google;

import java.util.LinkedList;
import java.util.Queue;

public class BicyclePersonMatch {
    
    public int[] BFS(char[][] grid, int[] employee) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(employee);
        visited[employee[0]][employee[1]] = true;
        int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            if (grid[cur[0]][cur[1]] == 'B') {
                return cur;
            }

            for (int[] d : dir) {
                int i = d[0] + cur[0];
                int j = d[1] + cur[1];
                if (i < 0 || i >= grid.length || j < 0 || j >= grid.length || visited[i][j] || grid[i][j] == '#') {
                    continue;
                }
                queue.add(new int[]{i, j});
                visited[i][j] = true;
            }
        }
        return null;
    }
}
