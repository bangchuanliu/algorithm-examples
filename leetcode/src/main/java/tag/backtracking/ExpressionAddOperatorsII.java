package tag.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExpressionAddOperatorsII {

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

        if (num.length() < 2 || !num.startsWith("0")) {
            prods.put(num, Long.parseLong(num));
        }

        for (int i = 1; i < num.length(); i++) {
            Map<String, Long> numOfWays1 = dfs(num.substring(0, i));
            Map<String, Long> numOfWays2 = dfs(num.substring(i));

            for (String a : numOfWays1.keySet()) {
                for (String b : numOfWays2.keySet()) {
                    prods.put(a + "+" + b, numOfWays1.get(a) + numOfWays2.get(b));
                    prods.put(a + "-" + b, numOfWays1.get(a) - numOfWays2.get(b));
                }
            }
        }
        return prods;
    }

    public List<String> addOperators2(String num, int target) {
        List<String> rst = new ArrayList<String>();
        if (num == null || num.length() == 0) return rst;
        helper(rst, "", num, target, 0, 0);
        return rst;
    }

    public void helper(List<String> rst, String path, String num, int target, int pos, long eval) {
        if (pos == num.length()) {
            if (target == eval)
                rst.add(path);
            return;
        }
        for (int i = pos; i < num.length(); i++) {
            if (i != pos && num.charAt(pos) == '0') break;
            long cur = Long.parseLong(num.substring(pos, i + 1));
            if (pos == 0) {
                helper(rst, path + cur, num, target, i + 1, cur);
            } else {
                helper(rst, path + "+" + cur, num, target, i + 1, eval + cur);

                helper(rst, path + "-" + cur, num, target, i + 1, eval - cur);
            }
        }
    }

    public static void main(String[] args) {
        ExpressionAddOperatorsII instance = new ExpressionAddOperatorsII();
        List<String> result = instance.addOperators("123456789", 45);
        List<String> result2 = instance.addOperators2("123456789", 45);
        System.out.println(Arrays.deepToString(result.toArray()));
        System.out.println(Arrays.deepToString(result2.toArray()));
    }
}
