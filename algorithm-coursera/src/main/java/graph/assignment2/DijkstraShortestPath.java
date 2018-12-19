package graph.assignment2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class DijkstraShortestPath {

    public static long[] shortestDistance(WeightedEdgeGraph graph, int v) {
        long[] dist = new long[graph.V() + 1];
        Set<Integer> vertices = new HashSet<>();
        vertices.add(v);

        while (vertices.size() < graph.V()) {
            long distance = Long.MAX_VALUE;
            int vertex = v;
            for (WeightedEdgeGraph.EdgeNode edge : graph.getEdges()) {
                int s = edge.getS();
                int t = edge.getT();
                int weight = edge.getWeight();
                if (vertices.contains(s)
                        && !vertices.contains(t)
                        && (dist[s] + weight) < distance) {
                    distance = dist[s] + weight;
                    vertex = t;
                }
            }
            if (vertex != v) {
                vertices.add(vertex);
                dist[vertex] = distance;
            } else {
                break;
            }
        }

        for (int i = 1; i <= graph.V(); i++) {
            if (!vertices.contains(i)) {
                dist[i] = 1000000;
            }
        }
        return dist;
    }

    public static void main(String[] args) throws IOException {
        String path = "/Users/b0l00ev/Documents/personal/data/dijkstraData.txt";
        List<String> list = Files.lines(Paths.get(path)).filter(str -> str.length() > 0).collect(Collectors.toList());
        WeightedEdgeGraph graph = new WeightedEdgeGraph(list.size());
        for (String line : list) {
            String[] str = line.split("\\s+");
            int u = Integer.parseInt(str[0]);
            for (int i = 1; i < str.length; i++) {
                String[] vertexWeight = str[i].split(",");
                graph.addEdge(u, Integer.parseInt(vertexWeight[0]), Integer.parseInt(vertexWeight[1]));
            }
        }

        long[] dist = shortestDistance(graph, 1);
        StringBuilder sb = new StringBuilder();
        sb.append(dist[7]).append(",")
                .append(dist[37]).append(",")
                .append(dist[59]).append(",")
                .append(dist[82]).append(",")
                .append(dist[99]).append(",")
                .append(dist[115]).append(",")
                .append(dist[133]).append(",")
                .append(dist[165]).append(",")
                .append(dist[188]).append(",")
                .append(dist[197]);
        System.out.println(sb.toString());
    }

}
