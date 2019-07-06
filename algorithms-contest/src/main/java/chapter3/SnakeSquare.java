package chapter3;

import java.util.Arrays;

public class SnakeSquare {

    public static void generateSnakeSquare(int[][] grid) {
        int x = 0;
        int y = grid.length - 1;
        int m = grid.length;

        int count = 1;
        grid[x][y] = count;

        while (count < m * m) {
            while (x+1 < m && grid[x+1][y] == 0) {
                grid[++x][y] = ++count;
            }

            while (y-1 >= 0 && grid[x][y - 1] == 0) {
                grid[x][--y] = ++count;
            }

            while (x - 1 >= 0 && grid[x-1][y] == 0) {
                grid[--x][y] = ++count;
            }

            while (y+1 < m &&  grid[x][y+1] == 0) {
                grid[x][++y] = ++count;
            }
        }
    }


    public static void main(String[] args) {
        int[][] grid = new int[3][3];
        generateSnakeSquare(grid);
        System.out.println(Arrays.deepToString(grid));

        grid = new int[2][2];
        generateSnakeSquare(grid);
        System.out.println(Arrays.deepToString(grid));

        grid = new int[1][1];
        generateSnakeSquare(grid);
        System.out.println(Arrays.deepToString(grid));

        grid = new int[4][4];
        generateSnakeSquare(grid);
        System.out.println(Arrays.deepToString(grid));
    }
}
