package leetcode.easy.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings s and t, determine if they are isomorphic.
 * 
 * Two strings are isomorphic if the characters in s can be replaced to get t.
 * 
 * All occurrences of a character must be replaced with another character while
 * preserving the order of characters. No two characters may map to the same
 * character but a character may map to itself.
 * 
 * For example, Given "egg", "add", return true.
 * 
 * Given "foo", "bar", return false.
 * 
 * Given "paper", "title", return true.
 * 
 * @author bliu13 Jan 13, 2016
 */
public class IsomorphicStrings {
	public boolean isIsomorphic(String s, String t) {

		if (s == null || t == null || s.length() != t.length()) {
			return false;
		}

		Map<Character, Character> maps = new HashMap<>();

		for (int i = 0; i < s.length(); i++) {
			if (maps.containsKey(s.charAt(i))) {
				if (maps.get(s.charAt(i)) != t.charAt(i)) {
					return false;
				}
			} else {
				if (maps.containsValue(t.charAt(i))) {
					return false;
				}
				maps.put(s.charAt(i), t.charAt(i));
			}
		}

		return true;
	}
}
