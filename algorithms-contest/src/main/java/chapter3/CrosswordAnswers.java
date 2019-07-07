package chapter3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CrosswordAnswers {
    
    public static List<List<String>> crosswords(char[][] grid) {
        
        int[][] number = new int[grid.length][grid[0].length];
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] != '*' && (i == 0 || j == 0 || grid[i-1][j] == '*' || grid[i][j-1] == '*')) {
                    count++;
                    number[i][j] = count;
                }
            }
        }
        
        List<List<String>> result = new ArrayList<>();
        
        for (int i = 0; i < grid.length; i++) {
            List<String> list = new ArrayList<>();
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '*') {
                    if (sb.length() > 0) {
                        list.add(sb.toString());
                        sb = new StringBuilder();
                    }
                }else {
                    if (sb.length() == 0) {
                        sb.append(number[i][j] + ".");
                    }
                    sb.append(grid[i][j]);
                }
            }
            if (sb.length() > 0) {
                list.add(sb.toString());
            }
            result.add(list);
        }

        for (int j = 0; j < grid[0].length; j++) {
            List<String> list = new ArrayList<>();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < grid.length; i++) {
                if (grid[i][j] == '*') {
                    if (sb.length() > 0) {
                        list.add(sb.toString());
                        sb = new StringBuilder();
                    }
                }else {
                    if (sb.length() == 0) {
                        sb.append(number[i][j] + ".");
                    }
                    sb.append(grid[i][j]);
                }
            }
            if (sb.length() > 0) {
                list.add(sb.toString());
            }
            result.add(list);
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        char[][] grid = {{'A','T'},{'*','O'}};
        List<List<String>> result = crosswords(grid);
        System.out.println(Arrays.deepToString(result.toArray()));
        char[][] grid2 = new char[6][7];
        grid2[0] = "AIM*DEN".toCharArray();
        grid2[1] = "*ME*ONE".toCharArray();
        grid2[2] = "UPON*TO".toCharArray();
        grid2[3] = "SO*ERIN".toCharArray();
        grid2[4] = "*SA*OR*".toCharArray();
        grid2[5] = "IES*DEA".toCharArray();

        System.out.println(Arrays.deepToString(crosswords(grid2).toArray()));
    }
}
