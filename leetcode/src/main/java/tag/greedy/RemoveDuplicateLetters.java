package tag.greedy;

import java.util.LinkedList;

/**
 * 
 * @author bliu13 Dec 30, 2015
 */
public class RemoveDuplicateLetters {

	/**
	 * O(k*n) k is the number of unique char
	 * 
	 * @param s
	 * @return
	 */
	public String removeDuplicateLetters(String s) {

		if (s == null || s.length() == 0) {
			return s;
		}

		int[] counter = new int[128];

		for (int i = 0; i < s.length(); i++) {
			counter[s.charAt(i)]++;
		}

		int pos = 0;

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) < s.charAt(pos)) {
				pos = i;
			}

			if (--counter[s.charAt(i)] == 0) {
				break;
			}
		}

		return s.charAt(pos) + "" + removeDuplicateLetters(s.substring(pos + 1).replaceAll(s.charAt(pos) + "", ""));
	}

	/**
	 * O(n)
	 * 
	 * @param s
	 * @return
	 */
	public String removeDuplicateLetters2(String s) {

		if (s == null || s.length() == 0) {
			return s;
		}

		int[] counter = new int[128];

		for (int i = 0; i < s.length(); i++) {
			counter[s.charAt(i)]++;
		}

		LinkedList<Character> stack = new LinkedList<Character>();
		stack.push(s.charAt(0));
		counter[s.charAt(0)]--;

		for (int i = 1; i < s.length(); i++) {
			counter[s.charAt(i)]--;
			if (!stack.contains(s.charAt(i))) {
				while (!stack.isEmpty() && s.charAt(i) < stack.peek() && counter[stack.peek()] > 0) {
					stack.pop();
				}
				stack.push(s.charAt(i));
			}
		}
		StringBuilder sb = new StringBuilder();
		while (!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		return sb.reverse().toString();
	}

	public static void main(String[] args) {
		RemoveDuplicateLetters instance = new RemoveDuplicateLetters();
		System.out.println(instance.removeDuplicateLetters2("bcabc"));
	}
}
