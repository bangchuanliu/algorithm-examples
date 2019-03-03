package tag.tree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SumofDistancesinTree {
    
    
    public int[] sumOfDistancesInTree(int N, int[][] edges) {
        int[][] dp = new int[N][N];
        List<Set<Integer>> graph = new ArrayList<Set<Integer>>();
        for (int[] edge : edges) {
            dp[edge[0]][edge[1]] = 1;
            dp[edge[1]][edge[0]] = 1;
        }
        
        for (int i = 0; i < N; ++i)
            graph.add(new HashSet<Integer>());
        for (int[] edge: edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        int[] dis = new int[N];

        for (int i = 0; i < dis.length; i++) {
            for (int j = 0; j < dis.length; j++) {
                dp[i][j] = dis(graph, i, j, dp,-1,0);
                dis[i] += dp[i][j];
            }
        }

        return dis;
    }

    public int dis(List<Set<Integer>> graph, int i, int j, int[][] dp, int parent, int len) {
        if (dp[i][j] > 0) {
            return dp[i][j];
        }
        if (i == j) {
            return len;
        }
        for (Integer v : graph.get(i)) {
            if (v != parent) {
                dis(graph, v, j, dp, i, len + 1);
            }
        }
        
        return 0;
    }
}
