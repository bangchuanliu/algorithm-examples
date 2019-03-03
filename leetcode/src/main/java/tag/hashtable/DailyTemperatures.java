package tag.hashtable;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperatures {

    public int[] dailyTemperatures(int[] T) {
        int[] result = new int[T.length];

       Stack<Integer> stack = new Stack<>();
       
       for (int i = T.length - 1; i >= 0; i--) {
           while (!stack.isEmpty() && T[stack.peek()] <= T[i]) {
               stack.pop();
           }
           result[i] = stack.isEmpty() ? 0 : stack.peek() - i;
           stack.push(i);
       }

        return result;
    }

    public static void main(String[] args) {
        DailyTemperatures dailyTemperatures = new DailyTemperatures();
        int[] T = {73, 74, 75, 71, 69, 72, 76, 73};
        System.out.println(Arrays.toString(dailyTemperatures.dailyTemperatures(T)));
    }
}
