package chapter4_1_undirectgraph;

import java.util.LinkedList;

public class BreadthFirstSearch {

    protected int count;
    protected boolean[] marked;

    public BreadthFirstSearch(Graph G, int s) {
        marked = new boolean[G.V()];
        bfs(G, s);
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

    private void bfs(Graph G, int s) {
        LinkedList<Integer> queue = new LinkedList<>();
        marked[s] = true;
        queue.add(s);
        while (!queue.isEmpty()) {
            int v = queue.poll();
            for (int w : G.adj(v)) {
                if (!marked[w]) {
                    marked[w] = true;
                    queue.add(w);
                }
            }
        }
    }
}
