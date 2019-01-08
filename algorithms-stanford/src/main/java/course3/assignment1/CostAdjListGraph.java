package course3.assignment1;

import java.util.LinkedList;

public class CostAdjListGraph {
    private int V;
    private int E;
    private LinkedList<VertexNode>[] adj;

    public CostAdjListGraph(int V) {
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
        VertexNode vertexNode1 = new VertexNode(w, cost);
        VertexNode vertexNode2 = new VertexNode(v, cost);
        adj[v].addFirst(vertexNode1);
        adj[w].addFirst(vertexNode2);
        E++;
    }

    class VertexNode {
        int w;
        int cost;

        VertexNode(int w, int cost) {
            this.w = w;
            this.cost = cost;
        }
    }

    public LinkedList<VertexNode> getAdj(int v) {
        return adj[v];
    }
}
