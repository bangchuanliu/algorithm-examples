package course4.assignment2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TSP {

    public static Double shortestPath(double[][] dist, int vertices, List<List<Integer>>[] subsets) {
        Map<Key, Double> result = new HashMap<>();
        result.put(new Key(Arrays.asList(1),1),0d);

        for (int m = 2; m <= vertices; m++) {
            for (List<Integer> subList : subsets[m]) {
                result.put(new Key(new ArrayList<>(subList), 1), Double.MAX_VALUE);
                for (Integer j : subList) {
                    if (j != 1) {
                        double d = Double.MAX_VALUE;
                        for (Integer k : subList) {
                            if (k != j) {
                                Key key = new Key(subList(subList, j), k);
                                d = Math.min(d, result.get(key) + dist[k][j]);
                            }
                        }
                        Key key2 = new Key(new ArrayList<>(subList), j);
                        result.put(key2, d);
                    }
                }
            }
        }

        Double d2 = Double.MAX_VALUE;

        for (int j = 2; j <= vertices; j++) {
            Key key3 = new Key(subsets[vertices].get(0), j);
            d2 = Math.min(d2, result.get(key3) + dist[j][1]);
        }

        return d2;
    }

    public static List<Integer> subList(List<Integer> list, int j) {
        List<Integer> result = new ArrayList<>();
        for (Integer v : list) {
            if (v != j) {
                result.add(v);
            }
        }
        return result;
    }

    public static List<List<Integer>>[] computeSubsets(int vertices) {
        List<Integer> temp = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        temp.add(1);
        subSet(vertices, temp, 2, result); //compute all subsets which contain 1

        List<List<Integer>>[] subsets = new List[vertices + 1];
        for (int i = 0; i < result.size(); i++) {
            int size = result.get(i).size();
            if (subsets[size] != null) {
                subsets[size].add(result.get(i));
            } else {
                List<List<Integer>> tempList = new ArrayList<>();
                tempList.add(result.get(i));
                subsets[size] = tempList;
            }
        }
        return subsets;
    }

    public static void subSet(int len, List<Integer> temp, int index, List<List<Integer>> result) {
        result.add(new ArrayList<>(temp));

        for (int i = index; i <= len; i++) {
            temp.add(i);
            subSet(len, temp, i + 1, result);
            temp.remove(temp.size() - 1);
        }
    }


    public static void runTest() throws IOException {
        String path = "/Users/b0l00ev/Documents/personal/data/test";
        List<String> list = Files.lines(Paths.get(path)).filter(str -> str.length() > 0).collect(Collectors.toList());
        int vertices = Integer.parseInt(list.get(0));
        double[][] dist = new double[vertices + 1][vertices + 1];
        for (int i = 1; i < list.size(); i++) {
            String[] str = list.get(i).split("\\s+");
            int u = Integer.parseInt(str[0]);
            int v = Integer.parseInt(str[1]);
            int l = Integer.parseInt(str[2]);
            dist[u][v] = l;
            dist[v][u] = l;
        }

        List<List<Integer>>[] map = computeSubsets(vertices);
        System.out.println(shortestPath(dist,vertices,map));
    }


    public static double run(String path) throws IOException {
        List<String> list = Files.lines(Paths.get(path)).filter(str -> str.length() > 0).collect(Collectors.toList());
        int vertices = Integer.parseInt(list.get(0));
        double[][] dist = new double[vertices + 1][vertices + 1];
        for (int i = 1; i < list.size() - 1; i++) {
            String[] str = list.get(i).split("\\s+");
            Point p1 = new Point(Double.parseDouble(str[0]), Double.parseDouble(str[1]));
            for (int j = i + 1; j < list.size(); j++) {
                String[] str2 = list.get(j).split("\\s+");
                Point p2 = new Point(Double.parseDouble(str2[0]), Double.parseDouble(str2[1]));
                dist[i][j] = p1.dist(p2);
                dist[j][i] = dist[i][j];
            }
        }
        List<List<Integer>>[] map = computeSubsets(vertices);
        return shortestPath(dist,vertices,map);
    }

    public static void main(String[] args) throws IOException {
        // result : 26442, plot the points and divide into two groups
        String path1 = TSP.class.getClassLoader().getResource("course4/assignment2/data/tsp1.txt").getPath();
        String path2 = TSP.class.getClassLoader().getResource("course4/assignment2/data/tsp2.txt").getPath();
        Point p1 = new Point(24166.6667d, 13250.0000);
        Point p2 = new Point(23883.3333, 14533.3333);
        System.out.println(run(path1) + run(path2) - 2 * p1.dist(p2));
//        runTest();
    }
}
