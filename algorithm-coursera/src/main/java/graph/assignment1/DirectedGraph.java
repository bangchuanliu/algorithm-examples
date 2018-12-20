package graph.assignment1;

import java.util.LinkedList;
import java.util.List;

public class DirectedGraph {
    private int V;
    private int E;
    private LinkedList<Integer>[] adj;

    public DirectedGraph(int V) {
        adj = new LinkedList[V + 1];
        this.V = V;
        for (int v = 0; v <= V; v++) {
            adj[v] = new LinkedList<>();
        }
    }

    public DirectedGraph reverse() {
        DirectedGraph newGraph = new DirectedGraph(V);
        for (int v = 0; v <= V; v++) {
            for (int w : adj[v]) {
                newGraph.addEdge(w, v);
            }
        }
        return newGraph;
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    public void addEdge(int v, int w) {
        adj[v].addFirst(w);
        E++;
    }

    public List<Integer> adj(int v) {
        return adj[v];
    }
}
