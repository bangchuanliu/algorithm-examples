package chapter3;

import java.util.Arrays;

public class SnakeRectangle {

    public static void generateSnakeRectangle(int[][] grid) {
        int x = 0;
        int y = grid[0].length - 1;
        int m = grid.length;
        int n = grid[0].length;

        int count = 1;
        grid[x][y] = count;

        while (count < m * n) {
            while (x+1 < m && grid[x+1][y] == 0) {
                grid[++x][y] = ++count;
            }

            while (y-1 >= 0 && grid[x][y - 1] == 0) {
                grid[x][--y] = ++count;
            }

            while (x - 1 >= 0 && grid[x-1][y] == 0) {
                grid[--x][y] = ++count;
            }

            while (y+1 < n &&  grid[x][y+1] == 0) {
                grid[x][++y] = ++count;
            }
        }
    }


    public static void main(String[] args) {
        int[][] grid = new int[1][3];
        generateSnakeRectangle(grid);
        System.out.println(Arrays.deepToString(grid));


        grid = new int[2][3];
        generateSnakeRectangle(grid);
        System.out.println(Arrays.deepToString(grid));

        grid = new int[3][3];
        generateSnakeRectangle(grid);
        System.out.println(Arrays.deepToString(grid));
    }
}
