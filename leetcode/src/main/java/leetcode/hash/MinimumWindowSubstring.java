package leetcode.hash;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

	public String minWindow(String s, String t) {
		if (s == null || t == null || s.length() < t.length()) {
			return "";
		}

		Map<Character, Integer> tMap = new HashMap<>();
		for (int i = 0; i < t.length(); i++) {
			Character ch = t.charAt(i);
			if (tMap.containsKey(ch)) {
				tMap.put(ch, tMap.get(ch) + 1);
			} else {
				tMap.put(ch, 1);
			}
		}

		Map<Character, Integer> sMap = new HashMap<>();
		int left = 0;
		int minLen = s.length() + 1;
		int count = 0;
		String result = "";

		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);

			if (tMap.containsKey(ch)) {
				if (sMap.containsKey(ch)) {
					if (sMap.get(ch) < tMap.get(ch)) {
						count++;
					}
					sMap.put(ch, sMap.get(ch) + 1);
				} else {
					count++;
					sMap.put(ch, 1);
				}
			}

			if (count == t.length()) {
				char sc = s.charAt(left);
				while (!sMap.containsKey(sc) || sMap.get(sc) > tMap.get(sc)) {
					if (sMap.containsKey(sc) && sMap.get(sc) > tMap.get(sc)) {
						sMap.put(sc, sMap.get(sc) - 1);
					}
					left++;
					sc = s.charAt(left);
				}

				if (i - left + 1 < minLen) {
					result = s.substring(left, i + 1);
					minLen = i - left + 1;
				}
			}
		}

		return result;
	}

	public String minWindow2(String s, String t) {
		if (s == null || t == null || s.length() < t.length()) {
			return "";
		}

		Map<Character, Integer> tMap = new HashMap<>();
		for (int i = 0; i < t.length(); i++) {
			Character ch = t.charAt(i);
			if (tMap.containsKey(ch)) {
				tMap.put(ch, tMap.get(ch) + 1);
			} else {
				tMap.put(ch, 1);
			}
		}

		int count = 0;
		int left = 0;
		int minLen = s.length() + 1;
		String result = "";

		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (tMap.containsKey(ch)) {
				tMap.put(ch, tMap.get(ch) - 1);
				if (tMap.get(ch) >= 0) {
					count++;
				}
			}

			while (count == t.length()) {
				char sc = s.charAt(left);
				if (tMap.containsKey(sc)) {
					tMap.put(sc, tMap.get(sc) + 1);
					if (tMap.get(sc) > 0) {
						count--;
					}
				}

				if (i - left + 1 < minLen) {
					result = s.substring(left, i + 1);
					minLen = i - left + 1;
				}

				left++;
			}
		}

		return result;
	}
}
