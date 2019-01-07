package course2.assignment2;


import java.util.LinkedList;
import java.util.List;

public class WeightedEdgeListGraph {
    private int V;
    private List<Edge> edges;

    public WeightedEdgeListGraph(int V) {
        this.V = V;
        edges = new LinkedList<>();
    }

    public int V() {
        return V;
    }

    public int E() {
        return edges.size();
    }

    public void addEdge(int v, int w, int weight) {
        Edge edge = new Edge(v, w, weight);
        edges.add(edge);
    }

    class Edge {
        public int u;
        public int v;
        public int weight;

        Edge(int u, int v, int weight) {
            this.u = u;
            this.v = v;
            this.weight = weight;
        }

    }

    public List<Edge> getEdges() {
        return edges;
    }
}
