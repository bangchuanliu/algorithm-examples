package chapter3.homework;

import java.util.HashMap;
import java.util.Map;

public class SixrectangularpalletsBox {
    
    public static boolean isBox(int[][] grid) {
        
        Map<Integer, Integer> count = new HashMap<>();
        
        for (int[] row : grid) {
            count.put(row[0], count.getOrDefault(row[0], 0) + 1);
            count.put(row[1], count.getOrDefault(row[1], 0) + 1);
        }
        
        if (count.size() > 3){
            return false;
        }
        
        for (int num : count.values()) {
            if (num % 4 != 0) {
                return false;
            }
        }
        
        return true;
    }
    
    public static void main(String[] args) {
        int[][] grid = {{1345,2584} , {2584,683}, {2584 ,1345},{683, 1345}, {683 ,1345},{2584, 683}};
        int[][] grid2 = {{1,2} , {1,1}, {1 ,1},{1, 1}, {1 ,1},{1, 2}};
        System.out.println(isBox(grid));
        System.out.println(isBox(grid2));
    }
}

