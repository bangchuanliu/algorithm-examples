package course1.assignment4;

import java.util.LinkedList;
import java.util.List;

public class EdgeListGraph {
    private int V;
    private int E;
    private List<Edge> edges;

    public EdgeListGraph(int V) {
        this.V = V;
        edges = new LinkedList<>();
    }

    public Edge getEdgeByIndex(int index) {
        if (index < 0 || index >= edges.size()) {
            return null;
        }
        return edges.get(index);
    }

    public int V() {
        return V;
    }

    public int E() {
        return edges.size();
    }

    public void contract(int v, int w) {
        for (Edge edge : edges) {
            if (edge.u == w) {
                edge.u = v;
            }
            if (edge.w == w) {
                edge.w = v;
            }
        }
        edges.removeIf(edge -> edge.u == edge.w);
        V--;
    }

    public void addEdge(int v, int w) {
        Edge edge = new Edge(v, w);
        edges.add(edge);
    }

    class Edge {
        public int u;
        public int w;

        Edge(int u, int w) {
            this.u = u;
            this.w = w;
        }

        @Override
        public String toString() {
            return u + "-" + w;
        }
    }

    public List<Edge> getEdges() {
        return edges;
    }
}
