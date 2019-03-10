package other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Util {

    public static void main(String[] args) {
        int[][] edges ={{0, 3}, {1, 3}, {2, 3}, {4, 3}, {5, 4}};
        System.out.println(Arrays.toString(findMinHeightTrees(6, edges).toArray()));
    }

    
    public  static List<Integer> findMinHeightTrees(int n, int[][] edges) {
        int[] degree = new int[n];
        for (int[] edge : edges) {
            degree[edge[0]]++;
            degree[edge[1]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < degree.length; i++) {
            if (degree[i] == 1) {
                queue.add(i);
            }
        }
        List<Integer> ret = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ret.add(i);
        }
        
        while (ret.size() > 2 && !queue.isEmpty()) {
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                int v = queue.poll();
                ret.remove(Integer.valueOf(v));
                for (int i = 0; i < edges.length; i++) {
                    if (edges[i][0] == v) {
                        degree[edges[i][1]]--;
                        if (degree[edges[i][1]] == 1) {
                            queue.add(edges[i][1]);
                        }
                    }else if (edges[i][1] == v) {
                        degree[edges[i][0]]--;
                        if (degree[edges[i][0]] == 1) {
                            queue.add(edges[i][0]);
                        }
                    }
                }
            }
        }
        
        return ret;
    }
}
