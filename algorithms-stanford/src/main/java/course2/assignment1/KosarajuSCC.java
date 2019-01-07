package course2.assignment1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class KosarajuSCC {

    static int count = 0;

    public static int[] stronglyConnected(DiGraph graph) {
        count = 0;
        int[] id = new int[graph.V() + 1];
        boolean[] marked = new boolean[graph.V() + 1];
        Stack<Integer> reverseOrder = dfsOrder(graph.reverse());
        while (!reverseOrder.isEmpty()) {
            int u = reverseOrder.pop();
            if (!marked[u]) {
                dfsSearch(graph, u, marked, id, count);
                count++;
            }
        }
        return id;
    }

    public static void dfsSearch(DiGraph graph, int v, boolean[] marked, int[] id, int count) {
        marked[v] = true;
        id[v] = count;
        for (Integer u : graph.adj(v)) {
            if (!marked[u]) {
                dfsSearch(graph, u, marked, id, count);
            }
        }
    }

    public static Stack<Integer> dfsOrder(DiGraph graph) {
        boolean[] marked = new boolean[graph.V() + 1];
        Stack<Integer> reverseOrder = new Stack<>();
        for (int i = 1; i <= graph.V(); i++) {
            if (!marked[i]) {
                dfsOrder(graph, i, reverseOrder, marked);
            }
        }

        return reverseOrder;
    }

    public static void dfsOrder(DiGraph graph, int v, Stack<Integer> reverseOrder, boolean[] marked) {
        marked[v] = true;
        for (Integer u : graph.adj(v)) {
            if (!marked[u]) {
                dfsOrder(graph, u, reverseOrder, marked);
            }
        }
        reverseOrder.push(v);
    }


    public static void main(String[] args) throws IOException {
        // -Xss16m 
        // 434821,968,459,313,211
        String path = KosarajuSCC.class.getClassLoader().getResource("course2/assignment1/data/SCC.txt").getPath();
        int V = 875714;
        DiGraph graph = new DiGraph(V);
        Files.lines(Paths.get(path)).forEach(line -> {
            String[] str = line.split("\\s+");
            graph.addEdge(Integer.parseInt(str[0]), Integer.parseInt(str[1]));
        });
        int[] id = stronglyConnected(graph);
        int[] cSize = new int[count];
        for (int i = 1; i < id.length; i++) {
            cSize[id[i]]++;
        }
        System.out.println("count : " + count);
        Arrays.sort(cSize);
        int j = cSize.length - 1;
        System.out.println(cSize[j] + "," + cSize[j - 1] + "," + cSize[j - 2] + "," + cSize[j - 3] + "," + cSize[j - 4]);
    }
}
