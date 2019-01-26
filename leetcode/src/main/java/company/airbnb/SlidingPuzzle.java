package company.airbnb;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class SlidingPuzzle {
    
    public static int slidingPuzzle(int[][] board) {
        Set<String> visited = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                sb.append(board[i][j]);
            }
        }
        String start = sb.toString();
        String end = "123450";
        Queue<String> queue = new LinkedList<>();
        queue.add(start);
        int count = 0;
        int[] d = {1,-1,3,-3};
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int index = 0; index < size; index++) {
                String str = queue.poll();
                if (str.equals(end)) {
                    return count;
                }
                int i = str.indexOf('0'); 
                for (Integer num : d) {
                    int j = i + num;
                    if (j < 0 || j > 5 || (j==2&&i==3) || (j==3&&i==2)) {
                        continue;
                    }
                    char[] chars = str.toCharArray();
                    char temp = chars[i];
                    chars[i] = chars[j];
                    chars[j] = temp;
                    String newString = new String(chars);
                    if (!visited.contains(newString)) {
                        visited.add(newString);
                        queue.add(newString);
                    }
                }
            }
            
            count++;
        }
        
        return -1;
    }

    public static void main(String[] args) {
        int[][] board = {{1,2,3},{5,4,0}};
        System.out.println(slidingPuzzle(board));
    }
}
