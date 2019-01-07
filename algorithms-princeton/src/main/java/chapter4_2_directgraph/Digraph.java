package chapter4_2_directgraph;

import java.util.LinkedList;
import java.util.List;

public class Digraph {
    protected int V;
    protected int E;
    protected LinkedList<Integer>[] adj;

    public Digraph(int V) {
        adj = new LinkedList[V];
        this.V = V;
        for (int v = 0; v < V; v++) {
            adj[v] = new LinkedList<>();
        }
    }

    public Digraph reverse() {
        Digraph newGraph = new Digraph(V);
        for (int v = 0; v < V; v++) {
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
