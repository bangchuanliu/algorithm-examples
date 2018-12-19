package graph.assignment2;

import java.util.LinkedList;

public class AdjacentListWeightedEdgeGraph {

    protected int V;
    protected int E;
    protected LinkedList<vertexNode>[] adj;

    public AdjacentListWeightedEdgeGraph(int V) {
        adj = new LinkedList[V + 1];
        this.V = V;
        for (int v = 0; v <= V; v++) {
            adj[v] = new LinkedList<>();
        }
    }

    public int V() {
        return V;
    }

    public int E() {
        return E / 2;
    }

    public void addEdge(int v, int w, int weight) {
        vertexNode vertexNode = new vertexNode(w, weight);
        adj[v].addFirst(vertexNode);
        E++;
    }

    class vertexNode {
        int v;
        int weight;

        vertexNode(int v, int weight) {
            this.v = v;
            this.weight = weight;
        }
    }

    public LinkedList<vertexNode> getAdj(int v) {
        return adj[v];
    }
}
