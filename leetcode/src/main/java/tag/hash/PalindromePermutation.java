package tag.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by bangchuanliu on 6/8/16.
 */
public class PalindromePermutation {

	public boolean canPermutePalindrome(String s) {
		if (s == null || s.length() == 0) {
			return false;
		}

		Map<Character, Integer> countMap = new HashMap<>();

		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (countMap.containsKey(ch)) {
				countMap.put(ch, countMap.get(ch) + 1);
			} else {
				countMap.put(ch, 1);
			}
		}
		int count = 0;
		for (Character ch : countMap.keySet()) {
			if (countMap.get(ch) % 2 != 0) {
				count++;
				if (count > 1) {
					return false;
				}
			}
		}

		return true;
	}
}
