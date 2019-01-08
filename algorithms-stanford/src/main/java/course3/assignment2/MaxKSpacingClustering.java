package course3.assignment2;

import course3.assignment1.CostEdgeListGraph;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class MaxKSpacingClustering {

    private static WeightedQuickUnionPathCompression uf;

    public static int maxKSpaceCluster(CostEdgeListGraph graph, int k) {
        uf = new WeightedQuickUnionPathCompression(graph.V());
        List<CostEdgeListGraph.Edge> edges = graph.getEdges();
        Collections.sort(edges, (o1, o2) -> (o1.cost - o2.cost));
        int i = 0;
        while (uf.getCount() > k && i < edges.size()) {
            CostEdgeListGraph.Edge edgeNode = edges.get(i);
            if (!uf.connected(edgeNode.u, edgeNode.v)) {
                uf.union(edgeNode.u, edgeNode.v);
            }
            i++;
        }
        while (i < edges.size()) {
            CostEdgeListGraph.Edge edgeNode = edges.get(i);
            if (!uf.connected(edgeNode.u, edgeNode.v)) {
                return edgeNode.cost;
            }
            i++;
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        //106
        String path = MaxKSpacingClustering.class.getClassLoader().getResource("course3/assignment2/data/clustering1.txt").getPath();
        List<String> list = Files.lines(Paths.get(path)).filter(str -> str.length() > 0).collect(Collectors.toList());
        CostEdgeListGraph graph = new CostEdgeListGraph(Integer.parseInt(list.get(0)));

        for (int i = 1; i < list.size(); i++) {
            String[] line = list.get(i).split("\\s+");
            graph.addEdge(Integer.parseInt(line[0]), Integer.parseInt(line[1]), Integer.parseInt(line[2]));
        }
        System.out.println(maxKSpaceCluster(graph, 4));
        System.out.println(uf.getCount());
    }
}
