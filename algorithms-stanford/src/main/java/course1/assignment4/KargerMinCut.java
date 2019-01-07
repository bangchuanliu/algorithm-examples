package course1.assignment4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class KargerMinCut {

    private static Random random = new Random();

    public static int minCut(EdgeListGraph G) {
        while (G.V() > 2) {
            randomContractGraph(G);
        }
        return G.getEdges().size() / 2;
    }

    public static void randomContractGraph(EdgeListGraph G) {
        int index = random.nextInt(G.E());
        EdgeListGraph.Edge edge = G.getEdgeByIndex(index);
        G.contract(edge.u, edge.w);
    }


    public static void main(String[] args) throws IOException {
        // 17
        int minCut = Integer.MAX_VALUE;
        for (int k = 0; k < 100; k++) {
            String path = KargerMinCut.class.getClassLoader().getResource("course1/assignment4/data/kargerMinCut.txt").getPath();
            List<String> list = Files.lines(Paths.get(path)).filter(str -> str.length() > 0).collect(Collectors.toList());
            EdgeListGraph graph = new EdgeListGraph(list.size());
            for (String line : list) {
                String[] str = line.split("\\s+");
                int u = Integer.parseInt(str[0]);
                for (int i = 1; i < str.length; i++) {
                    graph.addEdge(u, Integer.parseInt(str[i]));
                }
            }
            minCut = Math.min(minCut, minCut(graph));
        }
        System.out.println("minCut = " + minCut);
    }
}
