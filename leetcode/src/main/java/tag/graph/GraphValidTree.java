package tag.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GraphValidTree {
    
    public boolean validTree(int n, int[][] edges) {
        UF uf = new UF(n);
        for (int i = 0; i < edges.length; i++) {
            if (!uf.union(edges[i][0], edges[i][1])) {
                return false;
            }
        }
        
        return uf.count == 1;
    }


    class UF {
        int[] id;
        int count;

        UF(int N) {
            id = new int[N];
            for (int i = 0; i < N; i++) {
                id[i] = i;
            }
            count = N;
        }

        public int find(int p) {
            while (id[p] != p) {
                p = id[p];
            }
            return p;
        }

        public boolean union(int u, int v) {
            int p = find(u);
            int q = find(v);

            if (p == q) {
                return false;
            }

            id[p] = q;
            count--;
            return true;
        }
    }


    public boolean validTree2(int n, int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        
        for (int i = 0; i < edges.length; i++) {
            List<Integer> list = graph.getOrDefault(edges[i][0], new ArrayList<>());
            list.add(edges[i][1]);
            graph.put(edges[i][0], list);

            List<Integer> list2 = graph.getOrDefault(edges[i][1], new ArrayList<>());
            list2.add(edges[i][0]);
            graph.put(edges[i][1], list2);
        }
        
        boolean[] marked = new boolean[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!marked[i]) {
                count++;
                dfs(graph, marked, i, -1);
            }
        }
        
        return !hasCycle && count == 1;
    }
    
    boolean hasCycle = false;
    public void dfs(Map<Integer, List<Integer>> graph, boolean[] marked, int u, int parent) {
        if (hasCycle || graph.get(u) == null) {
            return;
        }
        
        marked[u] = true;
        
        for (Integer v : graph.get(u)) {
            if (!marked[v]) {
                dfs(graph, marked, v, u);
            } else if (parent != v){
                hasCycle = true;
            }
        }
    }
}


