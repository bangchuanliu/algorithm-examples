package tag.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EvaluateDivision {

    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        Map<String, List<Edge>> graph = new HashMap<>();
        for (int i = 0; i < equations.length; i++) {
            Edge edge = new Edge(equations[i][1], values[i]);
            List<Edge> list = graph.getOrDefault(equations[i][0], new ArrayList<>());
            list.add(edge);
            graph.put(equations[i][0], list);
            Edge edge2 = new Edge(equations[i][0], 1 / values[i]);
            List<Edge> list2 = graph.getOrDefault(equations[i][1], new ArrayList<>());
            list2.add(edge2);
            graph.put(equations[i][1], list2);
        }

        double[] ret = new double[queries.length];
        Arrays.fill(ret, -1.0);
        for (int i = 0; i < queries.length; i++) {
            Map<String, Boolean> marked = new HashMap<>();
            if (!graph.containsKey(queries[i][0]) || !graph.containsKey(queries[i][1])) {
                ret[i] = -1.0;
            } else {
                search(graph, queries[i][0], queries[i][1], 1.0, ret, i, marked);
            }
        }

        return ret;
    }

    public void search(Map<String, List<Edge>> graph, String start, String end, double prod, double[] ret, int i, Map<String, Boolean> marked) {
        if (start.equals(end)) {
            ret[i] = prod;
            return;
        }
        List<Edge> list = graph.get(start);

        for (Edge edge : list) {
            if (!marked.getOrDefault(edge.val, false)) {
                marked.put(edge.val, true);
                search(graph, edge.val, end, prod * edge.weight, ret, i, marked);
            }
        }
    }

    public static void main(String[] args) {
        String[][] equations = {{"a", "b"}, {"b", "c"}};
        double[] values = {2.0, 3.0};
        String[][] queries = {{"a", "c"}, {"b", "a"}, {"a", "e"}, {"a", "a"}, {"x", "x"}};
        EvaluateDivision evaluateDivision = new EvaluateDivision();
        double[] ret = evaluateDivision.calcEquation(equations, values, queries);
        System.out.println(Arrays.toString(ret));
    }
}
