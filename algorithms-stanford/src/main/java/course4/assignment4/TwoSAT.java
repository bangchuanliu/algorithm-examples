package course4.assignment4;

import course2.assignment1.DiGraph;
import course2.assignment1.KosarajuSCC;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class TwoSAT {

    public static boolean isSatisfy(DiGraph graph, int variables) {
        int[] id = KosarajuSCC.stronglyConnected(graph);

        for (int i = 1; i <= variables; i++) {
            if (id[i] == id[i + variables]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        //101100
        String path = "/Users/b0l00ev/Documents/personal/data/2sat1.txt";
        String path2 = "/Users/b0l00ev/Documents/personal/data/2sat2.txt";
        String path3 = "/Users/b0l00ev/Documents/personal/data/2sat3.txt";
        String path4 = "/Users/b0l00ev/Documents/personal/data/2sat4.txt";
        String path5 = "/Users/b0l00ev/Documents/personal/data/2sat5.txt";
        String path6 = "/Users/b0l00ev/Documents/personal/data/2sat6.txt";
        run(path);
        run(path2);
        run(path3);
        run(path4);
        run(path5);
        run(path6);
    }


    public static void run(String path) throws IOException {
        List<String> list = Files.lines(Paths.get(path)).filter(str -> str.length() > 0).collect(Collectors.toList());
        int vertices = Integer.parseInt(list.get(0));
        DiGraph graph = new DiGraph(vertices * 2);
        for (int i = 1; i < list.size(); i++) {
            String[] str = list.get(i).split("\\s+");
            int u = Integer.parseInt(str[0]);
            int v = Integer.parseInt(str[1]);
            if (u > 0 && v > 0) {
                graph.addEdge(u + vertices, v);
                graph.addEdge(v + vertices, u);
            } else if (u > 0 && v < 0) {
                graph.addEdge(u + vertices, -v + vertices);
                graph.addEdge(-v, u);
            } else if (u < 0 && v > 0) {
                graph.addEdge(-u, v);
                graph.addEdge(v + vertices, -u + vertices);
            } else {
                graph.addEdge(-u, -v + vertices);
                graph.addEdge(-v, -u + vertices);
            }
        }
        System.out.println(isSatisfy(graph, vertices));
    }
}
