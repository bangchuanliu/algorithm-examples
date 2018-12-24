package greedy.assignment1;

import java.util.LinkedList;
import java.util.List;

public class CostEdgeGraph {
    private int V;
    private int E;
    private LinkedList<EdgeNode> edges;

    public CostEdgeGraph(int V) {
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
        EdgeNode edge = new EdgeNode(v, w, cost);
        edges.addFirst(edge);
    }

    class EdgeNode {
        private int s;
        private int t;
        private int cost;

        EdgeNode(int s, int t, int cost) {
            this.s = s;
            this.t = t;
            this.cost = cost;
        }

        public int getS() {
            return s;
        }

        public int getCost() {
            return cost;
        }

        public int getT() {
            return t;
        }
    }

    public List<EdgeNode> getEdges() {
        return edges;
    }
}
