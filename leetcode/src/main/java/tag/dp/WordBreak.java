package tag.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Given a string s and a dictionary of words dict, determine if s can be
 * segmented into a space-separated sequence of one or more dictionary words.
 * 
 * For example, given s = "leetcode", dict = ["leet", "code"].
 * 
 * Return true because "leetcode" can be segmented as "leet code".
 * 
 * @author BangChuan Liu
 * @date 2015
 */
public class WordBreak {

	/**
	 * dp solution
	 * 
	 * @param s
	 * @param dict
	 * @return
	 */
	public boolean wordBreak(String s, Set<String> dict) {
		if (s == null || s.trim().length() == 0 || dict == null || dict.size() == 0) {
			return false;
		}
		if (dict.contains(s)) {
			return true;
		}
		Map<String, Boolean> map = new HashMap<String, Boolean>();
		Iterator<String> ite = dict.iterator();
		while (ite.hasNext()) {
			map.put(ite.next(), true);
		}
		return wordBreak(s, dict, map);
	}

	public boolean wordBreak(String s, Set<String> dict, Map<String, Boolean> map) {
		if (map.containsKey(s)) {
			return map.get(s);
		}
		if (dict.contains(s)) {
			return true;
		}
		map.put(s, false);
		int i = 1;
		while (i < s.length()) {
			if (dict.contains(s.substring(0, i))) {
				map.put(s.substring(0, i), true);
				Boolean isWordBreak = map.get(s.substring(i));
				if (isWordBreak == null) {
					isWordBreak = wordBreak(s.substring(i), dict, map);
					map.put(s.substring(i), isWordBreak);
				}
				if (isWordBreak) {
					map.put(s, true);
					break;
				}
			} else {
				map.put(s.substring(0, i), false);
			}
			i++;
		}
		return map.get(s);
	}

	/**
	 * dp solution
	 * 
	 * @param s
	 * @param dict
	 * @return
	 */
	public boolean wordBreakdp(String s, Set<String> dict) {
		boolean result[] = new boolean[s.length() + 1];
		result[0] = true;

		for (int i = 0; i < s.length(); i++) {
			if (!result[i]) {
				continue;
			}
			for (String word : dict) {
				int end = word.length() + i;
				if (end <= s.length() && !result[end] && s.substring(i, end).equals(word)) {
					result[end] = true;
				}
			}
		}
		return result[s.length()];
	}

	public static void main(String[] args) {
		WordBreak instance = new WordBreak();
		Set<String> dict = new HashSet<String>();
		dict.add("leet");
		dict.add("code");
		Map<String, Boolean> map = new HashMap<String, Boolean>();
		System.out.println(instance.wordBreakdp("aleetcode", dict));
		dict.clear();
		int i = 0;
		String str = "";
		while (i < 10) {
			str += "a";
			dict.add(str);
			i++;
		}
		String[] arr = new String[dict.size()];
		dict.toArray(arr);
		System.out.println(Arrays.toString(arr));
		System.out.println(instance.wordBreakdp(
				"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab",
				dict));

		String[] strs = { "programcree", "program", "creek" };
		dict = new HashSet<String>(Arrays.asList(strs));
		System.out.println(instance.wordBreak("programcreek", dict, map));
	}
}
