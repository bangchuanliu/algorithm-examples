package course2.assignment2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.stream.Collectors;

public class DijkstraShortestPathWithHeap {

    public static int[] shortestDistance(AdjListWeightedEdgeGraph graph, int s) {
        int[] dist = new int[graph.V() + 1];
        
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((o1, o2) -> (o1[1] - o2[1]));
        
        for (int i = 1; i < dist.length; i++) {
            if (i != s) {
                dist[i] = Integer.MAX_VALUE;
            }
            minHeap.add(new int[]{i, dist[i]});
        }
        
        Set<Integer> vertices = new HashSet<>();
        while (vertices.size() < graph.V()) {
            int u = minHeap.poll()[0];
            vertices.add(u);
            for (AdjListWeightedEdgeGraph.vertexNode vertexNode : graph.getAdj(u)) {
                if (!vertices.contains(vertexNode.v) && dist[u] + vertexNode.weight < dist[vertexNode.v]) {
                    minHeap.remove(new int[]{vertexNode.v, dist[vertexNode.v]});
                    dist[vertexNode.v] = dist[u] + vertexNode.weight;
                    minHeap.add(new int[]{vertexNode.v, dist[vertexNode.v]});
                }
            }
        }
        return dist;
    }

    public static void main(String[] args) throws IOException {
        // 2599,2610,2947,2052,2367,2399,2029,2442,2505,3068
        String path = DijkstraShortestPathWithHeap.class.getClassLoader().getResource("course2/assignment2/data/dijkstraData.txt").getPath();
        List<String> list = Files.lines(Paths.get(path)).filter(str -> str.length() > 0).collect(Collectors.toList());
        AdjListWeightedEdgeGraph graph = new AdjListWeightedEdgeGraph(list.size());
        for (String line : list) {
            String[] str = line.split("\\s+");
            int u = Integer.parseInt(str[0]);
            for (int i = 1; i < str.length; i++) {
                String[] vertexWeight = str[i].split(",");
                graph.addEdge(u, Integer.parseInt(vertexWeight[0]), Integer.parseInt(vertexWeight[1]));
            }
        }

        int[] dist = shortestDistance(graph, 1);
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
