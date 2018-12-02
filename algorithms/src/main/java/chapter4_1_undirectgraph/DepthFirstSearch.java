package chapter4_1_undirectgraph;


/**
 * find vertices connected to a source vertex s
 */
public class DepthFirstSearch {

    protected int count;
    protected boolean[] marked;

    public DepthFirstSearch(Graph G, int s) {
        marked = new boolean[G.V()];
        dfs(G, s);
    }

    /**
     * is v connected to s
     */
    public boolean marked(int v) {
        return marked[v];
    }

    /**
     * how many vertices are connected to s
     */
    public int count() {
        return count;
    }

    private void dfs(Graph G, int s) {
        marked[s] = true;
        count++;
        for (int w : G.adj(s)) {
            if (!marked[w]) {
                dfs(G, w);
            }
        }
    }
}
