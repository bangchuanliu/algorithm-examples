package tag.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExpressionAddOperators {

    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();

        dfs(result, "", 0, num, target, 0, 0);

        return result;

    }

    public void dfs(List<String> result, String exp, int index, String num, int target, long val, long mult) {
        if (index == num.length()) {
            if (val == target) {
                result.add(exp);
            }
            return;
        }

        for (int i = index; i < num.length(); i++) {
            if (i != index && num.charAt(index) == '0') break;

            long cur = Long.parseLong(num.substring(index, i + 1));

            if (index == 0) {
                dfs(result, exp + cur, i + 1, num, target, val + cur, cur);
            } else {
                dfs(result, exp + "+" + cur, i + 1, num, target, val + cur, cur);
                dfs(result, exp + "-" + cur, i + 1, num, target, val - cur, -cur);
                dfs(result, exp + "*" + cur, i + 1, num, target, val - mult + mult * cur, mult * cur);
            }
        }
    }

    /**
     * StringBuilder version
     * 
     */
    public List<String> addOperators2(String num, int target) {
        List<String> result = new ArrayList<>();

        dfs(result, new StringBuilder(), num, 0, target, 0, 0);

        return result;
    }


    public void dfs(List<String> result, StringBuilder sb, String num, int index, int target, long val, long mult) {
        if (index == num.length()) {
            if (target == val) {
                result.add(sb.toString());
            }

            return;
        }


        int len = sb.length();

        for (int i = index; i < num.length(); i++) {
            if (i != index && num.charAt(index) == '0') break;

            long cur = Long.parseLong(num.substring(index, i + 1));

            if (index == 0) {
                dfs(result, sb.append(cur), num, i + 1, target, cur, cur);
            } else {
                dfs(result, sb.append("+").append(cur), num, i + 1, target, val + cur, cur);
                sb.setLength(len);
                dfs(result, sb.append("-").append(cur), num, i + 1, target, val - cur, -cur);
                sb.setLength(len);
                dfs(result, sb.append("*").append(cur), num, i + 1, target, val - mult + mult * cur,
                        mult * cur);
                sb.setLength(len);
            }

            sb.setLength(len);
        }


    }


    public static void main(String[] args) {
        ExpressionAddOperators instance = new ExpressionAddOperators();
        List<String> result = instance.addOperators("999999999", 81);
        System.out.print(Arrays.deepToString(result.toArray()));
    }
}
