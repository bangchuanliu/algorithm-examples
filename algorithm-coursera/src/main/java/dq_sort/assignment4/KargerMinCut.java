package dq_sort.assignment4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class KargerMinCut {

    private static Random random = new Random();

    public static List<EdgeListGraph.Edge> minCut(EdgeListGraph G) {
        while (G.V() > 2) {
            randomContractGraph(G);
        }
        return G.getEdges();
    }

    public static void randomContractGraph(EdgeListGraph G) {
        int e = random.nextInt(G.E());
        int[] vw = G.getEdgeByIndex(e);
        G.contract(vw[0], vw[1]);
    }


    public static void main(String[] args) throws IOException {
        int minCut = Integer.MAX_VALUE;
        for (int k = 0; k < 100; k++) {
            String path = "/Users/b0l00ev/Documents/personal/data/kargerMinCut.txt";
            List<String> list = Files.lines(Paths.get(path)).filter(str -> str.length() > 0).collect(Collectors.toList());
            EdgeListGraph graph = new EdgeListGraph(list.size());
            for (String line : list) {
                String[] str = line.split("\\s+");
                int u = Integer.parseInt(str[0]);
                for (int i = 1; i < str.length; i++) {
                    graph.addEdge(u, Integer.parseInt(str[i]));
                }
            }

//            System.out.println(graph.V());
//            System.out.println(graph.E());
            List<EdgeListGraph.Edge> vertices = minCut(graph);
            minCut = Math.min(minCut, vertices.size());
//            for (EdgeListGraph.Edge v : vertices) {
//                System.out.print(v + ",");
////                for (Integer u : graph.adj(v)) {
////                    System.out.print(u + " ");
////                }
//            }
        }
        System.out.println("minCut = " + minCut/2);
    }
}
