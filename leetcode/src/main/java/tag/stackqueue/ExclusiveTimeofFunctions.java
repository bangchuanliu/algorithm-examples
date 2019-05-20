package tag.stackqueue;

import java.util.List;
import java.util.Stack;

public class ExclusiveTimeofFunctions {

    public int[] exclusiveTime(int n, List<String> logs) {
        if (n == 0) {
            return new int[0];
        }

        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();

        String[] strs = logs.get(0).split(":");
        stack.push(Integer.parseInt(strs[0]));
        int pre = Integer.parseInt(strs[2]);


        for (int i = 1; i < logs.size(); i++) {
            String[] cur = logs.get(i).split(":");

            if ("start".equals(cur[1])) {
                if (!stack.isEmpty()) {
                    result[stack.peek()] += Integer.parseInt(cur[2]) - pre;
                }
                stack.push(Integer.parseInt(cur[0]));
                pre = Integer.parseInt(cur[2]);
            } else {
                result[stack.pop()] += Integer.parseInt(cur[2]) - pre + 1;
                pre = Integer.parseInt(cur[2]) + 1;
            }

        }

        return result;
    }
}
