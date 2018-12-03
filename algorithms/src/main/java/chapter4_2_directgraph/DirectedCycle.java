package chapter4_2_directgraph;

import java.util.Stack;

public class DirectedCycle {
    private boolean[] marked;
    private int[] edgeTo;
    private Stack<Integer> cycle;
    private boolean[] onStack;

    public DirectedCycle(Digraph G) {
        edgeTo = new int[G.V()];
        onStack = new boolean[G.V()];
        marked = new boolean[G.V()];
        for (int s = 0; s < G.V(); s++) {
            if (!marked[s]) {
                dfs(G, s);
            }
        }
    }

    public boolean hasCycle() {
        return cycle != null;
    }

    public Iterable<Integer> cycle() {
        return cycle;
    }

    private void dfs(Digraph G, int s) {
        onStack[s] = true;
        marked[s] = true;
        for (int w : G.adj(s)) {
            if (hasCycle()) {
                return;
            } else if (!marked[w]) {
                edgeTo[w] = s;
                dfs(G, w);
            } else if (onStack[w]) { // encounter cycle
                cycle = new Stack<>();
                for (int x = s; x != w; x = edgeTo[x]) {
                    cycle.push(x);
                }
                cycle.push(w);
                cycle.push(s);
            }
        }
        onStack[s] = false;
    }
}
