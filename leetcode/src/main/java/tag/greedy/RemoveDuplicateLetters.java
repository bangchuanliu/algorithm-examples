package tag.greedy;

import java.util.Stack;

/**
 * @author bliu13 Dec 30, 2015
 */
public class RemoveDuplicateLetters {

    /**
     * O(n)
     */
    public String removeDuplicateLetters2(String s) {

        if (s == null || s.length() == 0) {
            return s;
        }

        int[] counter = new int[128];

        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i)]++;
        }

        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i)]--;
            if (!stack.contains(s.charAt(i))) {
                while (!stack.isEmpty() && s.charAt(i) < stack.peek() && counter[stack.peek()] > 0) {
                    stack.pop();
                }
                stack.push(s.charAt(i));
            }
        }
        String str = "";

        while (!stack.isEmpty()) {
            str = stack.pop() + str;
        }
        return str;
    }

    public static void main(String[] args) {
        RemoveDuplicateLetters instance = new RemoveDuplicateLetters();
        System.out.println(instance.removeDuplicateLetters2("bcabc"));
    }
}
