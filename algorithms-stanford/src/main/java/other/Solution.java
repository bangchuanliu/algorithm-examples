package other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;

public class Solution {
    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    int minimumDistance(int numRows, int numColumns, List<List<Integer>> area)
    {
        if (area == null || area.size() == 0) {
            return 0;
        }

        int min = 0;
        boolean[][] marked = new boolean[area.size()][area.get(0).size()];
        Queue<int[]> q = new LinkedList<>();
        int[] s = {0,0};
        q.add(s);
        marked[0][0] = true;

        while (!q.isEmpty()) {
            int size = q.size();

            min++;

            for (int i = 0; i < size; i++) {
                int[] temp = q.poll();

                if (area.get(temp[0]).get(temp[1]) == 9) {
                    return min - 1;
                }

                int[][] dir = {{1,0},{0,-1},{0,1},{-1,0}};

                for (int k = 0; k < dir.length; k++) {
                    int x = temp[0] + dir[k][0];
                    int y = temp[1] + dir[k][1];
                    if (x < 0 || x >= area.size()
                            || y < 0 || y >= area.get(0).size()
                            || area.get(x).get(y) == 0 || marked[x][y]) {
                        continue;
                    }
                    marked[x][y] = true;
                    int[] cur = {x,y};
                    q.add(cur);
                }
            }

        }

        return -1;
        // WRITE YOUR CODE HERE
    }
    
    public static void main(String[] args) {
        List<List<Integer>> area = new ArrayList<>();
        
        Integer[] a1 = {1,0,0};
        Integer[] a2 = {1,0,0};
        Integer[] a3 = {1,9,1};
        
        area.add(Arrays.asList(a1));
        area.add(Arrays.asList(a2));
        area.add(Arrays.asList(a3));

        Solution solution = new Solution();
        System.out.println(solution.minimumDistance(3,3,area));
        
    }
}
