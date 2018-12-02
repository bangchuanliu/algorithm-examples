package chapter4_1_undirectgraph;

public class Cycle {

    private boolean[] marked;
    private boolean hasCycle;

    public Cycle(Graph G) {
        marked = new boolean[G.V()];
        for (int s = 0; s < G.V(); s++) {
            if (!marked[s]) {
                dfs(G, s, s);    
            }
        }
    }

    public boolean hasCycle() {
        return hasCycle;
    }
    
    private void dfs(Graph G, int s, int u) {
        marked[s] = true;
        for (int w : G.adj(s)) {
            if (!marked[w]) {
                dfs(G, w, s);
            } else if (w != u) {
                hasCycle = true;
            }
        }
    }
}
