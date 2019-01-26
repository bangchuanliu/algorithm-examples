package tag.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsofaPhoneNumber {

	public List<String> letterCombinations(String digits) {
		List<String> result = new ArrayList<>();

		if (digits == null || digits.length() == 0) {
			return result;
		}

		Map<Character, String> digitsLetterMap = new HashMap<>();
		digitsLetterMap.put('1', "");
		digitsLetterMap.put('2', "abc");
		digitsLetterMap.put('3', "def");
		digitsLetterMap.put('4', "ghi");
		digitsLetterMap.put('5', "jkl");
		digitsLetterMap.put('6', "mno");
		digitsLetterMap.put('7', "pqrs");
		digitsLetterMap.put('8', "tuv");
		digitsLetterMap.put('9', "wxyz");

		letterCombinations(digits, result, digitsLetterMap, "");

		return result;
	}

	public void letterCombinations(String digits, List<String> result, Map<Character, String> maps, String temp) {
		if (digits == null || digits.length() == 0) {
			result.add(temp);
			return;
		}

		Character ch = digits.charAt(0);
		String letters = maps.get(ch);

		for (int i = 0; i < letters.length(); i++) {
			letterCombinations(digits.substring(1), result, maps, temp + letters.charAt(i));
		}
	}

	public void letterCombinations(String digits, List<String> result, Map<Character, String> maps, int index,
			StringBuilder sb) {

		if (index == digits.length()) {
			result.add(sb.toString());
			return;
		}

		String letters = maps.get(digits.charAt(index));

		for (int i = 0; i < letters.length(); i++) {
			sb.append(letters.charAt(i));
			letterCombinations(digits, result, maps, index + 1, sb);
			sb.deleteCharAt(sb.length() - 1);
		}
	}

}
