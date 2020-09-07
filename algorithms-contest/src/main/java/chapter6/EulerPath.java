package chapter6;

import java.util.*;

public class EulerPath {
    public static void main(String[] args) {
        int[] n1 = {4, 1};
        int[] n4 = {1, 4};
        int[] n2 = {4, 2};
        int[] n3 = {2, 5};

        List<int[]> list = Arrays.asList(n1, n2, n3,n4);
        List<Integer> result = new ArrayList<>();
        Map<String, Integer> edgeCount = new HashMap<>();

        for (int[] e : list) {
            String uv = e[0] < e[1] ? e[0] + "," + e[1] : e[1] + "," + e[0];
            edgeCount.put(uv, edgeCount.getOrDefault(uv, 0) + 1);
        }
        result.add(1);  
        path(list, result, 1, edgeCount);


        System.out.println(Arrays.toString(result.toArray()));
    }

    public static void path(List<int[]> list, List<Integer> result, int u, Map<String, Integer> edgeCount) {
        for (int[] e : list) {
            if (e[0] == u || e[1] == u) {
                String uv = e[0] < e[1] ? e[0] + "," + e[1] : e[1] + "," + e[0];
                if (edgeCount.get(uv) > 0) {
                    int v = e[0] == u ? e[1] : e[0];
                    result.add(v);
                    edgeCount.put(uv, edgeCount.get(uv) - 1);
                    path(list, result, v, edgeCount);
                }
            }
        }
    }
}
