package chapter4_1_undirectgraph;

import java.util.LinkedList;

public class BreadthFirstPaths {

    protected boolean[] marked;
    protected int[] edgeTo;
    protected final int s;

    public BreadthFirstPaths(Graph G, int s) {
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        this.s = s;
        bfs(G, s);
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

    private void bfs(Graph G, int s) {
        LinkedList<Integer> queue = new LinkedList<>();
        marked[s] = true;
        queue.add(s);
        while (!queue.isEmpty()) {
            int v = queue.poll();
            for (int w : G.adj(v)) {
                if (!marked[w]) {
                    edgeTo[w] = v;
                    marked[w] = true;
                    queue.add(w);
                }
            }
        }
    }
}
