package leetcode.hash;

import java.util.HashMap;
import java.util.Map;


/**
 * 
 * Given a pattern and a string str, find if str follows the same pattern.
 * 
 * Here follow means a full match, such that there is a bijection between a
 * letter in pattern and a non-empty word in str.
 * 
 * Examples: pattern = "abba", str = "dog cat cat dog" should return true.
 * pattern = "abba", str = "dog cat cat fish" should return false. pattern =
 * "aaaa", str = "dog cat cat dog" should return false. pattern = "abba", str =
 * "dog dog dog dog" should return false. Notes: You may assume pattern contains
 * only lowercase letters, and str contains lowercase letters separated by a
 * single space.
 * 
 * @author bliu13 Jan 13, 2016
 */
public class WordPattern {
	public boolean wordPattern(String pattern, String str) {

		if (pattern == null || str == null || pattern == "" || str == "") {
			return false;
		}

		String[] words = str.split(" ");

		if (pattern.length() != words.length) {
			return false;
		}

		Map<Character, String> letterWord = new HashMap<>();

		for (int i = 0; i < pattern.length(); i++) {
			if (letterWord.containsKey(pattern.charAt(i))) {
				if (!(letterWord.get(pattern.charAt(i))).equals(words[i])) {
					return false;
				}
			} else {
				if (letterWord.containsValue(words[i])) {
					return false;
				} else {
					letterWord.put(pattern.charAt(i), words[i]);
				}
			}
		}

		return true;
	}
}
