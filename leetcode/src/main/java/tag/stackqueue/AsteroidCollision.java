package tag.stackqueue;

import java.util.Stack;

public class AsteroidCollision {

    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int a : asteroids) {
            if (a < 0) {
                while (!stack.isEmpty() && stack.peek() < -a && stack.peek() >= 0) {
                    stack.pop();
                }

                if (stack.isEmpty() || stack.peek() < 0) {
                    stack.push(a);
                } else if (stack.peek() == -a) {
                    stack.pop();
                }
            } else {
                stack.push(a);
            }
        }


        int[] result = new int[stack.size()];
        int i = result.length - 1;
        while (!stack.isEmpty()) {
            result[i--] = stack.pop();
        }

        return result;
    }
}
