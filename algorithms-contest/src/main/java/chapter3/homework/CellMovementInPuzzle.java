package chapter3.homework;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CellMovementInPuzzle {
    
    public static void cellMovement(char[][] grid, String input) {
        if (input == null || input.length() == 0) {
            return;
        }
        
        Map<Character, int[]> map = new HashMap<>();
        map.put('A', new int[]{-1,0});
        map.put('B', new int[]{1,0});
        map.put('L', new int[]{0,-1});
        map.put('R', new int[]{0,1});
        
        int a = 0; 
        int b = 0;
        
        for (int i = 0 ; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == ' ') {
                    a = i;
                    b = j;
                    break;
                }
            }
        }
        
        
        for (char c : input.toCharArray()) {
            int[] d = map.get(c);
            int x = a + d[0];
            int y = b + d[1];
            
            if (x < 0 || x >= grid.length || y < 0 || y > grid.length) {
                System.out.println("This puzzle has no final configuration");
                return;
            }
            
            grid[a][b] = grid[x][y];
            a = x;
            b = y;
            grid[x][y] = ' ';
        }
    }
    
    public static void main(String[] args) {
        char[][] grid = {{'T','R','G','S','J'},{'X','D','O','K','I'},{'M', ' ', 'V','L','N'},{'W','P','A','B','E'},{'U','Q','H','C','F'}};
        String input = "ARRBBL";
        cellMovement(grid,input);
        System.out.println(Arrays.deepToString(grid));

        cellMovement(grid,"AAAAAAAAA");
        System.out.println(Arrays.deepToString(grid));
    }
}
