package chapter3.example;

import java.util.Arrays;

public class SnakeSquare {

    public static int[][] generateSnakeSquare(int n) {
        if (n <= 0) {
            return null;
        }

        int[][] grid = new int[n][n];
        int x = 0;
        int y = n - 1;
        int count = 1;
        grid[x][y] = count;
        
        while (count < n * n) {
            while (x + 1 < n && grid[x+1][y] == 0) {
                grid[++x][y] = ++count;
            }

            while (y - 1 >= 0 && grid[x][y-1] == 0) {
                grid[x][--y] = ++count;
            }

            while (x - 1 >= 0 && grid[x-1][y] == 0) {
                grid[--x][y] = ++count;
            }

            while (y + 1 < n && grid[x][y+1] == 0) {
                grid[x][++y] = ++count;
            }
        }
        
        return grid;
    }


    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(generateSnakeSquare(1)));
        System.out.println(Arrays.deepToString(generateSnakeSquare(2)));
        System.out.println(Arrays.deepToString(generateSnakeSquare(3)));
        System.out.println(Arrays.deepToString(generateSnakeSquare(4)));
    }
}
