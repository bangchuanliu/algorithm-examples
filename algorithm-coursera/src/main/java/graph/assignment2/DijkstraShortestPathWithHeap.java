package graph.assignment2;

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

    static class HeapKey {
        int v;
        long dist;

        HeapKey(int v, long dist) {
            this.v = v;
            this.dist = dist;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            HeapKey heapKey = (HeapKey) o;
            return v == heapKey.v;
        }

        @Override
        public int hashCode() {
            return Objects.hash(v);
        }
    }

    public static long[] shortestDistance(AdjacentListWeightedEdgeGraph graph, int v) {
        long[] dist = new long[graph.V() + 1];
        PriorityQueue<HeapKey> minHeap = new PriorityQueue<>(new Comparator<HeapKey>() {
            public int compare(HeapKey o1, HeapKey o2) {
                return (int) (o1.dist - o2.dist);
            }
        });
        for (int i = 1; i < dist.length; i++) {
            if (i != v) {
                dist[i] = Integer.MAX_VALUE;
            }
            HeapKey heapKey = new HeapKey(i, dist[i]);
            minHeap.add(heapKey);
        }
        Set<Integer> vertices = new HashSet<>();
        while (vertices.size() < graph.V()) {
            int u = minHeap.poll().v;
            vertices.add(u);
            for (AdjacentListWeightedEdgeGraph.vertexNode vertexNode : graph.getAdj(u)) {
                if (!vertices.contains(vertexNode.v) && dist[u] + vertexNode.weight < dist[vertexNode.v]) {
                    minHeap.remove(new HeapKey(vertexNode.v,dist[vertexNode.v]));
                    dist[vertexNode.v] = dist[u] + vertexNode.weight;
                    minHeap.add(new HeapKey(vertexNode.v,dist[vertexNode.v]));
                }
            }
        }
        return dist;
    }

    public static void main(String[] args) throws IOException {
        String path = "/Users/b0l00ev/Documents/personal/data/dijkstraData.txt";
        List<String> list = Files.lines(Paths.get(path)).filter(str -> str.length() > 0).collect(Collectors.toList());
        AdjacentListWeightedEdgeGraph graph = new AdjacentListWeightedEdgeGraph(list.size());
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
