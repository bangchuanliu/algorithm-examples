package tag.bfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class WallsAndGates {

    public void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0) {
            return;
        }

        int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[i].length; j++) {
                if (rooms[i][j] == 0) {
                    q.add(new int[]{i, j});
                }
            }
        }

        while (!q.isEmpty()) {
            int[] p = q.poll();

            for (int[] d : dir) {
                int x = p[0] + d[0];
                int y = p[1] + d[1];

                if (x < 0 || x >= rooms.length || y < 0 || y >= rooms[0].length
                        || rooms[x][y] != Integer.MAX_VALUE) {
                    continue;
                }
                rooms[x][y] = rooms[p[0]][p[1]] + 1;
                q.add(new int[]{x, y});
            }
        }
    }


    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        int[][] rooms = {{2147483647, -1, 0, 2147483647}, {2147483647, 2147483647, 2147483647, -1}, {2147483647, -1, 2147483647, -1}, {0, -1, 2147483647, 2147483647}};
        WallsAndGates wallsAndGates = new WallsAndGates();
        wallsAndGates.wallsAndGates(rooms);
        System.out.println(Arrays.deepToString(rooms));
    }
}
