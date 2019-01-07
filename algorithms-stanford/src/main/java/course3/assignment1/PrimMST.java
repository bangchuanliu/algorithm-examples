package course3.assignment1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class PrimMST {

    public static long minCost(CostEdgeGraph graph) {
        Set<Integer> vertices = new HashSet<>();
        CostEdgeGraph.EdgeNode edgeNode = null;
        long minSum = 0;
        vertices.add(1);  // pick any arbitrary vertex

        while (vertices.size() < graph.V()) {
            int minCost = Integer.MAX_VALUE;
            edgeNode = null;
            for (CostEdgeGraph.EdgeNode edge : graph.getEdges()) {
                int s = edge.getS();
                int t = edge.getT();
                int cost = edge.getCost();
                if (isQualifiedEdge(vertices, s, t) && cost <= minCost) {
                    edgeNode = edge;
                    minCost = cost;
                }
            }
            if (edgeNode != null) {
                vertices.add(edgeNode.getT());
                vertices.add(edgeNode.getS());
                minSum += edgeNode.getCost();
            }
        }
        return minSum;
    }

    public static boolean isQualifiedEdge(Set<Integer> vertices, int s, int t) {
        return (vertices.contains(s) && !vertices.contains(t))
                || (vertices.contains(t) && !vertices.contains(s));
    }

    public static void main(String[] args) throws IOException {
        // -3612829
        String path = "/Users/b0l00ev/Documents/personal/data/mst_edges.txt";
        List<String> list = Files.lines(Paths.get(path)).filter(str -> str.length() > 0).collect(Collectors.toList());
        CostEdgeGraph graph = new CostEdgeGraph(Integer.parseInt(list.get(0).split("\\s+")[0]));

        for (int i = 1; i < list.size(); i++) {
            String[] line = list.get(i).split("\\s+");
            graph.addEdge(Integer.parseInt(line[0]), Integer.parseInt(line[1]), Integer.parseInt(line[2]));
        }
        System.out.println(minCost(graph));
    }
}
