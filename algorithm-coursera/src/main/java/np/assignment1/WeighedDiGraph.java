package np.assignment1;

import java.util.LinkedList;
import java.util.List;

public class WeighedDiGraph {

    private int V;
    private int E;
    private LinkedList<Edge>[] adj;

    public WeighedDiGraph(int V) {
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
        return E;
    }

    public void addEdge(int v, int w, int weight) {
        Edge edge = new Edge(w, weight);
        adj[v].addFirst(edge);
        E++;
    }
    
    public class Edge {
        int v;
        int weight;

        Edge(int v, int weight) {
            this.v = v;
            this.weight = weight;
        }
    }

    public List<Edge> adj(int v) {
        return adj[v];
    }
}
