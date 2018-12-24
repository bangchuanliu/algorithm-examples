package greedy.assignment1;

import java.util.LinkedList;

public class CostAdjacentListGraph {
    private int V;
    private int E;
    private LinkedList<VertexNode>[] adj;

    public CostAdjacentListGraph(int V) {
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

    public void addEdge(int v, int w, int cost) {
        VertexNode vertexNode = new VertexNode(w, cost);
        adj[v].addFirst(vertexNode);
        E++;
    }

    class VertexNode {
        int v;
        int cost;

        VertexNode(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }
    }

    public LinkedList<VertexNode> getAdj(int v) {
        return adj[v];
    }
}
