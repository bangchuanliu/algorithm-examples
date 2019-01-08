package course3.assignment1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class PrimMST {

    public static long minCost(CostEdgeListGraph graph) {
        long minSum = 0;
        Set<Integer> vertices = new HashSet<>();
        vertices.add(1);  // pick any arbitrary vertex

        while (vertices.size() < graph.V()) {
            int minCost = Integer.MAX_VALUE;
            CostEdgeListGraph.Edge minCostEdge = null;
            for (CostEdgeListGraph.Edge edge : graph.getEdges()) {
                if (isQualifiedEdge(vertices, edge.u, edge.v) && edge.cost <= minCost) {
                    minCostEdge = edge;
                    minCost = edge.cost;
                }
            }
            vertices.add(minCostEdge.u);
            vertices.add(minCostEdge.v);
            minSum += minCost;
        }
        return minSum;
    }

    public static boolean isQualifiedEdge(Set<Integer> vertices, int s, int t) {
        return (vertices.contains(s) && !vertices.contains(t))
                || (vertices.contains(t) && !vertices.contains(s));
    }

    public static void main(String[] args) throws IOException {
        // -3612829
        String path = PrimMST.class.getClassLoader().getResource("course3/assignment1/data/mst_edges.txt").getPath();
        List<String> list = Files.lines(Paths.get(path)).filter(str -> str.length() > 0).collect(Collectors.toList());
        CostEdgeListGraph graph = new CostEdgeListGraph(Integer.parseInt(list.get(0).split("\\s+")[0]));

        for (int i = 1; i < list.size(); i++) {
            String[] line = list.get(i).split("\\s+");
            graph.addEdge(Integer.parseInt(line[0]), Integer.parseInt(line[1]), Integer.parseInt(line[2]));
        }
        System.out.println(minCost(graph));
    }
}
