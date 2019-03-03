package tag.bfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class IsGraphBipartite {

    public boolean isBipartite(int[][] graph) {
        int[] color = new int[graph.length];
        Arrays.fill(color, -1);

        for (int i = 0; i < graph.length; i++) {
            if (color[i] == -1) {
                Queue<Integer> q = new LinkedList<>();
                q.add(i);
                color[i] = 0;

                while (!q.isEmpty()) {
                    int size = q.size();
                    for (int j = 0; j < size; j++) {
                        int node = q.poll();
                        for (int v : graph[node]) {
                            if (color[v] == color[node]) {
                                return false;
                            } else if (color[v] == -1) {
                                color[v] = color[node] ^ 1;
                                q.add(v);
                            }
                        }
                    }

                }
            }
        }

        return true;
    }
}
