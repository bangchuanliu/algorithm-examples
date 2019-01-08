package leetcode.easy.stackqueue;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and
 * ']', determine if the input string is valid.
 * 
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid
 * but "(]" and "([)]" are not.
 * 
 * @author BangChuan Liu <liubangchuan1100@gmail.com>
 *
 * @date Oct 30, 2014
 */
public class ValidParentheses {

	public boolean isValid(String s) {
		if (s == null || s.trim().length() == 0) {
			return true;
		}
		
		Map<Character, Character> charMap = new HashMap<>();
		charMap.put(')', '(');
		charMap.put(']', '[');
		charMap.put('}', '{');
		
		LinkedList<Character> stack = new LinkedList<Character>();
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (ch == '(' || ch == '[' || ch == '{') {
				stack.push(ch);
			} else {
				if (!stack.isEmpty() && stack.peek().charValue() == charMap.get(ch)) {
					stack.pop();
				} else {
					return false;
				}
			} 
		}
		return stack.isEmpty();
	}

	public static void main(String[] args) {
		System.out.println(new ValidParentheses().isValid("}"));
		System.out.println(new ValidParentheses().isValid("(])"));
		System.out.println(new ValidParentheses().isValid("()[]{}"));
		System.out.println(new ValidParentheses().isValid("(]"));
		System.out.println(new ValidParentheses().isValid("([)]"));
	}
}
