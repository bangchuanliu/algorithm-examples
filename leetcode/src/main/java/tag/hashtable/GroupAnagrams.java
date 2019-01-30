package tag.hashtable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author bliu13 Jan 17, 2016
 */
public class GroupAnagrams {
	public List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> result = new ArrayList<>();

		if (strs == null || strs.length == 0) {
			return result;
		}
		Arrays.sort(strs);
		Map<String, List<String>> map = new HashMap<>();

		for (String str : strs) {
			char[] strChars = str.toCharArray();
			Arrays.sort(strChars);
			String newStr = new String(strChars);
			if (map.containsKey(newStr)) {
				map.get(newStr).add(str);
			} else {
				List<String> strList = new ArrayList<>();
				strList.add(str);
				map.put(newStr, strList);
			}
		}

		result.addAll(map.values());

		return result;
	}
}
