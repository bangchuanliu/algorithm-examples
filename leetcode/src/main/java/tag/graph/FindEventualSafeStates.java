package tag.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindEventualSafeStates {

    public List<Integer> eventualSafeNodes(int[][] graph) {
        Queue<Integer> queue = new LinkedList<>();
        int[] degree = new int[graph.length];
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < graph.length; i++) {
            if (graph[i].length == 0) {
                queue.add(i);
            }
        }

        List<Integer>[] reversedGraph = new List[graph.length];
        for (int i = 0; i < reversedGraph.length; i++) {
            reversedGraph[i] = new ArrayList<>();
        }

        for (int i = 0; i < graph.length; i++) {
            for (int v : graph[i]) {
                degree[i]++;
                reversedGraph[v].add(i);
            }
        }

        while (!queue.isEmpty()) {
            int v = queue.poll();
            for (int u : reversedGraph[v]) {
                degree[u]--;
                if (degree[u] == 0) {
                    queue.add(u);
                }
            }
            result.add(v);
        }
        Collections.sort(result);
        return result;
    }
    
    public static void main(String[] args){
        FindEventualSafeStates findEventualSafeStates = new FindEventualSafeStates();
        int[][] graph = {{},{0,2,3,4},{3},{4},{}};
        System.out.println(Arrays.toString(findEventualSafeStates.eventualSafeNodes(graph).toArray()));
    }
}
