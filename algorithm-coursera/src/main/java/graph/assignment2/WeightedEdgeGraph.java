package graph.assignment2;


import java.util.LinkedList;
import java.util.List;

public class WeightedEdgeGraph {
    private int V;
    private int E;
    private List<EdgeNode> edges;

    public WeightedEdgeGraph(int V) {
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
        EdgeNode edge = new EdgeNode(v, w, weight);
        edges.add(edge);
    }

    class EdgeNode {
        private int s;
        private int t;
        private int weight;

        EdgeNode(int s, int t, int weight) {
            this.s = s;
            this.t = t;
            this.weight = weight;
        }

        public int getS() {
            return s;
        }

        public int getWeight() {
            return weight;
        }

        public int getT() {
            return t;
        }
    }

    public List<EdgeNode> getEdges() {
        return edges;
    }
}
