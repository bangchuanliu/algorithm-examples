package course3.assignment1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class PrimMSTAdjacentListGraph {

    public static long minCostByAdjcentListGraph(CostAdjacentListGraph graph) {
        Set<Integer> vertices = new HashSet<>();
        long minSum = 0;
        vertices.add(1);  // pick any arbitrary vertex
        CostAdjacentListGraph.VertexNode node = null;
        while (vertices.size() < graph.V()) {
            int minCost = Integer.MAX_VALUE;
            for (Integer u : vertices) {
                for (CostAdjacentListGraph.VertexNode vertexNode : graph.getAdj(u)) {
                    if (!vertices.contains(vertexNode.w) && vertexNode.cost <= minCost) {
                        node = vertexNode;
                        minCost = vertexNode.cost;
                    }
                }
            }
            if (node != null) {
                vertices.add(node.w);
                minSum += minCost;
            }
        }

        return minSum;
    }

    public static void main(String[] args) throws IOException {
        // -3612829
        String path = "/Users/b0l00ev/Documents/personal/data/mst_edges.txt";
        List<String> list = Files.lines(Paths.get(path)).filter(str -> str.length() > 0).collect(Collectors.toList());
        CostAdjacentListGraph graph = new CostAdjacentListGraph(Integer.parseInt(list.get(0).split("\\s+")[0]));

        for (int i = 1; i < list.size(); i++) {
            String[] line = list.get(i).split("\\s+");
            graph.addEdge(Integer.parseInt(line[0]), Integer.parseInt(line[1]), Integer.parseInt(line[2]));
        }
        System.out.println(minCostByAdjcentListGraph(graph));
    }
}
