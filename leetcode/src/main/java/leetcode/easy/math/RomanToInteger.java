package leetcode.easy.math;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a roman numeral, convert it to an integer.
 * <p>
 * Input is guaranteed to be within the range from 1 to 3999.
 *
 * @author BangChuan Liu <liubangchuan1100@gmail.com>
 * @date Oct 29, 2014
 */
public class RomanToInteger {

	public int romanToInt(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}

		Map<Character, Integer> map = new HashMap<>();
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);

		int num = map.get(s.charAt(0));
		int pre = num;
		for (int i = 1; i < s.length(); i++) {
			int cur = map.get(s.charAt(i));
			num += cur;

			if (cur > pre) {
				num -= 2 * pre;
			}
			pre = cur;
		}

		return num;
	}
}
