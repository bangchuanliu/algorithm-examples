package tag.unionfind;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EvaluateDivision {
    
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

        Map<String, String> parent = new HashMap<>();
        Map<String, Double> dist = new HashMap<>();

        for (int i = 0; i < equations.size(); i++) {
            String p1 = findParent(parent, dist, equations.get(i).get(0));
            String p2 = findParent(parent, dist, equations.get(i).get(1));
            parent.put(p1, p2);
            dist.put(p1, dist.get(equations.get(i).get(1)) * values[i] / dist.get(equations.get(i).get(0)));
        }


        double[] result = new double[queries.size()];
        Arrays.fill(result, -1.0);

        for (int i = 0; i < queries.size(); i++) {
            if (parent.containsKey(queries.get(i).get(0)) && parent.containsKey(queries.get(i).get(1))) {
                String r1 = findParent(parent, dist, queries.get(i).get(0));
                String r2 = findParent(parent, dist, queries.get(i).get(1));
                if (r1.equals(r2)) {
                    result[i] = dist.get(queries.get(i).get(0)) / dist.get(queries.get(i).get(1));
                }
            }
        }

        return result;
    }


    public String findParent(Map<String, String> parent, Map<String, Double> dist, String s) {
        if (!parent.containsKey(s) || parent.get(s).equals(s)) {
            parent.put(s, s);
            dist.put(s, 1.0);

            return s;
        }

        String lastParent = parent.get(s);
        String root = findParent(parent, dist, lastParent);

        parent.put(s, root);
        dist.put(s, dist.get(lastParent) * dist.get(s));

        return root;
    }
}
