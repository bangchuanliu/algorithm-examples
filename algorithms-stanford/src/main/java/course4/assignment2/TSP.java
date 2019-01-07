package course4.assignment2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TSP {

    public static Double shortestPath(double[][] dist, int vertices, Map<Integer, List<List<Integer>>> subsetsMap) {
        Map<MapKey, Double> result = new HashMap<>();
        List<Integer> set1 = new ArrayList<>();
        set1.add(1);
        result.put(new MapKey(set1,1),0d);

        for (int m = 2; m <= vertices; m++) {
            for (List<Integer> subList : subsetsMap.get(m)) {
                result.put(new MapKey(new ArrayList<>(subList), 1), Double.MAX_VALUE);
                for (Integer j : subList) {
                    if (j != 1) {
                        double d = Double.MAX_VALUE;
                        for (Integer k : subList) {
                            if (k != j) {
                                MapKey key = new MapKey(subList(subList, j), k);
                                d = Math.min(d, result.get(key) + dist[k][j]);
                            }
                        }
                        MapKey key2 = new MapKey(new ArrayList<>(subList), j);
                        result.put(key2, d);
                    }
                }
            }
        }

        Double d2 = Double.MAX_VALUE;

        for (int j = 2; j <= vertices; j++) {
            MapKey key3 = new MapKey(subsetsMap.get(vertices).get(0), j);
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

    public static void print2D(double[][] dist) {
        for (int i = 1; i < dist.length; i++) {
            for (int j = 1; j < dist.length; j++) {
                System.out.print("dist[" + i + "][" + j + "]=" + dist[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static Map<Integer, List<List<Integer>>> computeSubsets(int vertices) {
        List<Integer> temp = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        temp.add(1);
        subSet(vertices, temp, 2, result);

        Map<Integer, List<List<Integer>>> map = new HashMap<>();
        for (int i = 0; i < result.size(); i++) {
            int size = result.get(i).size();
            if (map.containsKey(size)) {
                map.get(size).add(result.get(i));
            } else {
                List<List<Integer>> tempList = new ArrayList<>();
                tempList.add(result.get(i));
                map.put(size, tempList);
            }
        }
        return map;
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

        Map<Integer, List<List<Integer>>> map = computeSubsets(vertices);
        System.out.println(shortestPath(dist,vertices,map));
    }


    public static void run() throws IOException {
        String path = "/Users/b0l00ev/Documents/personal/data/test3";
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
        Map<Integer, List<List<Integer>>> map = computeSubsets(vertices);
        System.out.println(shortestPath(dist,vertices,map));
    }

    public static void main(String[] args) throws IOException {
        // result : 26442, plot the points and divide into two groups
        run();
//        runTest();
    }
}
