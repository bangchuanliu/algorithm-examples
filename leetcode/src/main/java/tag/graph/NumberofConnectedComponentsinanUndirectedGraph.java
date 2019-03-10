package tag.graph;

import java.util.ArrayList;
import java.util.List;

public class NumberofConnectedComponentsinanUndirectedGraph {

    public int countComponents(int n, int[][] edges) {
        List<Integer>[] graph = new List[n];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < edges.length; i++) {
            graph[edges[i][0]].add(edges[i][1]);
            graph[edges[i][1]].add(edges[i][0]);
        }

        int count = 0;
        boolean[] marked = new boolean[n];
        for (int i = 0; i < graph.length; i++) {
            if (!marked[i]) {
                count++;
                dfs(graph, marked, i);
            }
        }
        return count;
    }


    public void dfs(List<Integer>[] graph, boolean[] marked, int v) {
        marked[v] = true;
        for (int u : graph[v]) {
            if (!marked[u]) {
                dfs(graph, marked, u);    
            }
        }
    }
}
