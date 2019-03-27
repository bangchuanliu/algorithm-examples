package tag.bfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class RemoveInvalidParentheses {

    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();

        Set<String> marked = new HashSet<>();
        LinkedList<String> queue = new LinkedList<>();
        queue.add(s);
        marked.add(s);
        boolean found = false;

        while (!queue.isEmpty()) {
            String str = queue.poll();
            if (isvalid(str)) {
                result.add(str);
                found = true;
            }

            if (found) {
                continue;
            }

            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '(' || str.charAt(i) == ')') {
                    String temp = str.substring(0, i) + str.substring(i + 1);
                    if (!marked.contains(temp)) {
                        marked.add(temp);
                        queue.add(temp);
                    }
                }
            }
        }
        return result;
    }

    public boolean isvalid(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                count++;
            } else if (s.charAt(i) == ')') {
                count--;
            }
            if (count < 0) {
                return false;
            }
        }

        return count == 0;
    }

    public static void main(String[] args) {
        RemoveInvalidParentheses removeInvalidParentheses = new RemoveInvalidParentheses();
        List<String> ret = removeInvalidParentheses.removeInvalidParentheses(")(");
        System.out.println(Arrays.toString(ret.toArray()));
    }
}
