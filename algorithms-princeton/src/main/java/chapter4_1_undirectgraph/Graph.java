package chapter4_1_undirectgraph;

import java.util.LinkedList;
import java.util.List;


/**
 * Undirected Graph
 */
public class Graph {

    protected int V;
    protected int E;
    protected LinkedList<Integer>[] adj;

    public Graph(int V) {
        adj = new LinkedList[V];
        this.V = V;
        for (int v = 0; v < V; v++) {
            adj[v] = new LinkedList<>();
        }
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    public void addEdge(int v, int w) {
        adj[v].addFirst(w);
        adj[w].addFirst(v);
        E++;
    }

    public List<Integer> adj(int v) {
        return adj[v];
    }

}
