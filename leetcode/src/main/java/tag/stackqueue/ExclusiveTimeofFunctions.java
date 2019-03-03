package tag.stackqueue;

import java.util.List;
import java.util.Stack;

public class ExclusiveTimeofFunctions {

    public int[] exclusiveTime(int n, List<String> logs) {
        int[] result = new int[n];
        if (logs.size() == 0) {
            return result;
        }
        Stack<String> stack = new Stack();

        String[] strs = logs.get(0).split(":");
        stack.push(strs[0]);
        int pre = Integer.parseInt(strs[2]);

        for (int i = 1; i < logs.size(); i++) {
            String[] cur = logs.get(i).split(":");
            if ("start".equals(cur[1])) {
                if (!stack.isEmpty()) {
                    result[Integer.parseInt(stack.peek())] += Integer.parseInt(cur[2]) - pre;
                }
                stack.push(cur[0]);
                pre = Integer.parseInt(cur[2]);
            } else if ("end".equals(cur[1])) {
                result[Integer.parseInt(stack.peek())] += Integer.parseInt(cur[2]) - pre + 1;
                stack.pop();
                pre = Integer.parseInt(cur[2]) + 1;
            }

        }

        return result;
    }
}
