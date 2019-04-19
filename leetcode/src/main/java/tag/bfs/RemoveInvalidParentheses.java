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

    // return one valid string
    public String oneValidString(String str) {
        StringBuilder sb = new StringBuilder();
        int open = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '(') {
                open++;
                sb.append(c);
            } else if (c == ')') {
                if (open > 0) {
                    sb.append(c);
                    open--;
                }
            } else {
                sb.append(c);
            }
        }
        open = 0;
        for (int i = sb.length() - 1; i >= 0; i--) {
            if (sb.charAt(i) == ')') {
                open++;
            } else if (sb.charAt(i) == '(') {
                if (open == 0) {
                    sb.deleteCharAt(i);
                } else {
                    open--;
                }
            }
        }
        return sb.toString();
    }

    
    // DFS
    public List<String> removeInvalidParentheses2(String s) {
        int l = 0;
        int r = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                l++;
            }else if (s.charAt(i) == ')') {
                if (l > 0) {
                    l--;
                }else {
                    r++;
                }
            }
        }

        Set<String> ret = new HashSet<>();
        dfs(0, s, new StringBuilder(), l, r, 0, ret);

        return new ArrayList<>(ret);
    }




    public void dfs(int index, String s, StringBuilder sb, int l, int r, int count, Set<String> ret) {
        if (l < 0 || r < 0 || count < 0) {
            return;
        }

        if (index == s.length()) {
            if (l == 0 && r == 0 && count == 0) {
                ret.add(sb.toString());
            }
            return;
        }

        int len = sb.length();

        if (s.charAt(index) == '(') {
            dfs(index+1, s, sb, l - 1, r, count, ret);
            dfs(index+1, s, sb.append(s.charAt(index)), l, r, count+1, ret);
        }else if (s.charAt(index) == ')') {
            dfs(index+1, s, sb, l, r-1, count, ret);
            dfs(index+1, s, sb.append(s.charAt(index)), l, r, count-1, ret);
        }else {
            dfs(index+1, s, sb.append(s.charAt(index)), l, r, count, ret);
        }
        sb.setLength(len);
    }
    
    public static void main(String[] args) {
        RemoveInvalidParentheses removeInvalidParentheses = new RemoveInvalidParentheses();
//        List<String> ret = removeInvalidParentheses.removeInvalidParentheses(")(");
//        System.out.println(Arrays.toString(ret.toArray()));


        System.out.println(removeInvalidParentheses.oneValidString(")("));
    }
}
