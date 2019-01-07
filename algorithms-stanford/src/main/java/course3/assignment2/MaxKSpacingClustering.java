package course3.assignment2;

import course3.assignment1.CostEdgeGraph;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MaxKSpacingClustering {

    private static WeightedQuickUnionPathCompression uf;

    public static int maxKSpaceCluster(CostEdgeGraph graph, int k) {
        uf = new WeightedQuickUnionPathCompression(graph.V());
        List<CostEdgeGraph.EdgeNode> edges = graph.getEdges();
        Collections.sort(edges, new Comparator<CostEdgeGraph.EdgeNode>() {
            @Override
            public int compare(CostEdgeGraph.EdgeNode o1, CostEdgeGraph.EdgeNode o2) {
                return o1.getCost() - o2.getCost();
            }
        });
        int i = 0;
        while (uf.getCount() > k && i < edges.size()) {
            CostEdgeGraph.EdgeNode edgeNode = edges.get(i);
            if (!uf.connected(edgeNode.getS(), edgeNode.getT())) {
                uf.union(edgeNode.getS(), edgeNode.getT());
            }
            i++;
        }
        while (i < edges.size()) {
            CostEdgeGraph.EdgeNode edgeNode = edges.get(i);
            if (!uf.connected(edgeNode.getS(), edgeNode.getT())) {
                return edgeNode.getCost();
            }
            i++;
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        //106
        String path = "/Users/b0l00ev/Documents/personal/data/clustering1.txt";
        List<String> list = Files.lines(Paths.get(path)).filter(str -> str.length() > 0).collect(Collectors.toList());
        CostEdgeGraph graph = new CostEdgeGraph(Integer.parseInt(list.get(0)));

        for (int i = 1; i < list.size(); i++) {
            String[] line = list.get(i).split("\\s+");
            graph.addEdge(Integer.parseInt(line[0]), Integer.parseInt(line[1]), Integer.parseInt(line[2]));
        }
        System.out.println(maxKSpaceCluster(graph, 4));
        System.out.println(uf.getCount());
    }
}
