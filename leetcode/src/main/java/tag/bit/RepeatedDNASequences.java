package tag.bit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class RepeatedDNASequences {

	public List<String> findRepeatedDnaSequences(String s) {
		List<String> result = new ArrayList<>();

		if (s == null) {
			return result;
		}

		Map<Character, Integer> map = new HashMap<>();
		map.put('A', 0);
		map.put('C', 1);
		map.put('G', 2);
		map.put('T', 3);

		int hash = 0;
		Set<Integer> nums = new HashSet<>();
		Set<Integer> added = new HashSet<>();

		for (int i = 0; i < s.length(); i++) {
			if (i < 9) {
				hash = (hash << 2) + map.get(s.charAt(i));
			} else {
				hash = (hash << 2) + map.get(s.charAt(i));
				hash = hash & (1 << 20) - 1;
				if (nums.contains(hash) && !added.contains(hash)) {
					result.add(s.substring(i - 9, i + 1));
					added.add(hash);
				} else {
					nums.add(hash);
				}
			}
		}

		return result;
	}

	public List<String> findRepeatedDnaSequences2(String s) {
		List<String> list = new ArrayList<>();
		if (s == null || s.length() <= 10) {
			return list;
		}

		Map<String, Integer> map = new HashMap<>();

		int i = 0;
		StringBuilder sb = new StringBuilder();
		for (; i < 10; i++) {
			sb.append(s.charAt(i));
		}
		map.put(sb.toString(), 1);
		while (i < s.length()) {
			sb.deleteCharAt(0);
			sb.append(s.charAt(i));
			if (map.containsKey(sb.toString())) {
				map.put(sb.toString(), map.get(sb.toString()) + 1);
			} else {
				map.put(sb.toString(), 1);
			}
			i++;
		}

		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			if (entry.getValue() > 1) {
				list.add(entry.getKey());
			}
		}
		return list;
	}

	public static void main(String[] args) {
		RepeatedDNASequences instance = new RepeatedDNASequences();
		instance.findRepeatedDnaSequences("CAAAAAAAAAC");
	}
}
