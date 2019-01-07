package chapter4_1_undirectgraph;

public class ConnectedComponent {

    private int[] id;
    private boolean[] marked;
    private int count;

    public ConnectedComponent(Graph G) {
        id = new int[G.V()];
        marked = new boolean[G.V()];

        for (int v = 0; v < G.V(); v++) {
            if (!marked[v]) {
                dfs(G, v);
                count++;
            }
        }
    }

    /**
     * are v and w connected
     */
    boolean connected(int v, int w) {
        return id[w] == id[v];
    }

    /**
     * number of connected components
     */
    public int count() {
        return count;
    }

    /***
     *  component identifier for v
     */
    int id(int v) {
        return id[v];
    }

    private void dfs(Graph G, int s) {
        marked[s] = true;
        id[s] = count;
        for (int w : G.adj(s)) {
            if (!marked[w]) {
                marked[w] = true;
                dfs(G,w);
            }
        }
    }
}
