package course4.assignment1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class FloydWarsshallAPSP {

    public static Integer APSP(WeighedDiGraph graph) {
        int vertices = graph.V();
        int[][][] A = new int[graph.V() + 1][graph.V() + 1][graph.V() + 1];
        for (int i = 1; i <= vertices; i++) {
            for (int j = 1; j <= vertices; j++) {
                if (i == j) {
                    A[i][j][0] = 0;
                } else {
                    A[i][j][0] = weight(graph, i, j);
                }
            }
        }
        for (int k = 1; k <= vertices; k++) {
            for (int i = 1; i <= vertices; i++) {
                for (int j = 1; j <= vertices; j++) {
                    if (A[i][k][k - 1] == Integer.MAX_VALUE || A[k][j][k - 1] == Integer.MAX_VALUE) {
                        A[i][j][k] = A[i][j][k - 1];
                    } else {
                        A[i][j][k] = Math.min(A[i][j][k - 1], A[i][k][k - 1] + A[k][j][k - 1]);
                    }
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= vertices; i++) {
            for (int j = 1; j <= vertices; j++) {
                if (i == j) {
                    if (A[i][j][vertices] != 0) {
                        return null;
                    }
                } else {
                    min = Math.min(min, A[i][j][vertices]);
                }
            }
        }
        return min;
    }

    public static int weight(WeighedDiGraph graph, int i, int j) {
        int weight = Integer.MAX_VALUE;
        for (WeighedDiGraph.Edge edge : graph.adj(i)) {
            if (edge.v == j) {
                return edge.weight;
            }
        }
        return weight;
    }

    public static void main(String[] args) throws IOException {
        // -19
        String path1 = FloydWarsshallAPSP.class.getClassLoader().getResource("course4/assignment1/data/g1.txt").getPath();
        String path2 = FloydWarsshallAPSP.class.getClassLoader().getResource("course4/assignment1/data/g2.txt").getPath();
        String path3 = FloydWarsshallAPSP.class.getClassLoader().getResource("course4/assignment1/data/g3.txt").getPath();
        System.out.println(APSP(graph(path1)));
        System.out.println(APSP(graph(path2)));
        System.out.println(APSP(graph(path3)));
    }
    
    public static WeighedDiGraph graph(String path) throws IOException {
        List<String> list = Files.lines(Paths.get(path)).filter(str -> str.length() > 0).collect(Collectors.toList());
        int vertices = Integer.parseInt(list.get(0).split(" ")[0]);
        int edges = Integer.parseInt(list.get(0).split(" ")[1]);
        WeighedDiGraph graph = new WeighedDiGraph(vertices);
        for (int i = 1; i < list.size(); i++) {
            String[] str = list.get(i).split("\\s+");
            graph.addEdge(Integer.parseInt(str[0]), Integer.parseInt(str[1]), Integer.parseInt(str[2]));
        }
        
        return graph;
    }
}
