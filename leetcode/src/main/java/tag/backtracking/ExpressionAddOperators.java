package tag.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExpressionAddOperators {

    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();
        Map<String, Long> prods = dfs(num);

        for (String key : prods.keySet()) {
            if (prods.get(key) == target) {
                result.add(key);
            }
        }
        return result;
    }

    public Map<String, Long> dfs(String num) {
        Map<String, Long> prods = new HashMap<>();
        if (num.isEmpty()) {
            return prods;
        }
        if (num.length() < 2 || !num.startsWith("0")) {
            prods.put(num, Long.parseLong(num));
        }
        for (int i = 1; i < num.length(); i++) {
            Map<String, Long> numOfWays1 = dfs(num.substring(0, i));
            Map<String, Long> numOfWays2 = dfs(num.substring(i));

            for (String a : numOfWays1.keySet()) {
                for (String b : numOfWays2.keySet()) {
                    calculate(a, b, numOfWays1, numOfWays2, prods);
                }
            }
        }
        return prods;
    }

    public void calculate(String a, String b, Map<String, Long> numOfWays1, Map<String, Long> numOfWays2, Map<String, Long> prods) {
        long x = numOfWays1.get(a);
        long y = numOfWays2.get(b);
        prods.put(a + "+" + b, x + y);
        prods.put(a + "-" + b, x - y);
        int i = a.length() - 1;
        while (i >= 0 && Character.isDigit(a.charAt(i))) {
            i--;
        }
        int j = 0;
        while (j < b.length() && Character.isDigit(b.charAt(j))) {
            j++;
        }
        if ((i < 0 || a.charAt(i) == '*')
                && (j == b.length() || b.charAt(j) == '*')) {
            prods.put(a + "*" + b, x * y);
        }
    }


    public static void main(String[] args) {
        ExpressionAddOperators instance = new ExpressionAddOperators();
        List<String> result = instance.addOperators("123456789", 45);
        System.out.print(Arrays.deepToString(result.toArray()));
    }
}
