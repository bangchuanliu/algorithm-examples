package chapter4_1_undirectgraph;


import java.util.LinkedList;

/**
 * find paths connected to a source vertex s
 */
public class DepthFirstPaths {

    protected boolean[] marked;
    protected int[] edgeTo;
    protected final int s;

    public DepthFirstPaths(Graph G, int s) {
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        this.s = s;
        dfs(G, s);
    }

    boolean hasPathTo(int v) {
        return marked[v];
    }

    LinkedList<Integer> pathTo(int v) {
        if (!hasPathTo(v)) {
            return null;
        }
        LinkedList<Integer> stack = new LinkedList<>();
        for (int x = v; x != s; x = edgeTo[x]) {
            stack.push(x);
        }
        stack.push(s);
        return stack;
    }

    private void dfs(Graph G, int s) {
        marked[s] = true;
        for (int w : G.adj(s)) {
            if (!marked[w]) {
                edgeTo[w] = s;   // if w has more than one vertex point to, choose one
                dfs(G, w);
            }
        }
    }
}
