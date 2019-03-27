package tag.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MostStonesRemovedwithSameRoworColumn {
    public int removeStones(int[][] stones) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int i = 0; i < stones.length; i++) {
            for (int j = i+1; j < stones.length; j++) {
                if (stones[i][0] == stones[j][0]) {
                    List<int[]> list = graph.getOrDefault(stones[i][0], new ArrayList<>());
                    list.add(stones[j]);
                    graph.put(stones[i][0], list);        
                }
                if (stones[i][0] == stones[j][0]) {
                    List<int[]> list2 = graph.getOrDefault(stones[i][1], new ArrayList<>());
                    list2.add(stones[j]);
                    graph.put(stones[i][1], list2);
                }
            }
        }
        Set<int[]> set = new HashSet<>();
        int count = 0;
        for (int i = 0; i < stones.length; i++) {
            if (!set.contains(stones[i])) {
                count++;
                dfs(graph, set, stones[i]);
            }
        }

        return stones.length - count;
    }

    public void dfs(Map<Integer, List<int[]>> graph, Set<int[]> set, int[] v) {
        for (int[] u : graph.getOrDefault(v[0], new ArrayList<>())) {
            if (!set.contains(u)) {
                set.add(u);
                dfs(graph, set, u);
            }
        }
        for (int[] u : graph.getOrDefault(v[1], new ArrayList<>())) {
            if (!set.contains(u)) {
                set.add(u);
                dfs(graph, set, u);
            }
        }
    }
    public static void main(String[] args) {
        int[][] stones = {{1, 0}, {0, 1},{1,1}};
        MostStonesRemovedwithSameRoworColumn mostStonesRemovedwithSameRoworColumn = new MostStonesRemovedwithSameRoworColumn();
        System.out.println(mostStonesRemovedwithSameRoworColumn.removeStones(stones));
    }
}
