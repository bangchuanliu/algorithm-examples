package course3.assignment1;

import java.util.LinkedList;
import java.util.List;

public class CostEdgeListGraph {
    private int V;
    private int E;
    private LinkedList<Edge> edges;

    public CostEdgeListGraph(int V) {
        this.V = V;
        edges = new LinkedList<>();
    }

    public int V() {
        return V;
    }

    public int E() {
        return edges.size();
    }

    public void addEdge(int v, int w, int cost) {
        Edge edge = new Edge(v, w, cost);
        edges.addFirst(edge);
    }

    public class Edge {
        public int u;
        public int v;
        public int cost;

        Edge(int u, int v, int cost) {
            this.u = u;
            this.v = v;
            this.cost = cost;
        }
    }

    public List<Edge> getEdges() {
        return edges;
    }
}
