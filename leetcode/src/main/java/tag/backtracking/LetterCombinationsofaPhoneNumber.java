package tag.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsofaPhoneNumber {

	public List<String> letterCombinations(String digits) {
		List<String> result = new ArrayList<>();

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

		letterCombinations(digits, result, digitsLetterMap, "", 0);

		return result;
	}

	public void letterCombinations(String digits, List<String> result, Map<Character, String> maps, String temp, int index) {
		if (index == digits.length()) {
			result.add(temp);
			return;
		}

		Character ch = digits.charAt(index);
		String letters = maps.get(ch);

		for (int i = 0; i < letters.length(); i++) {
			letterCombinations(digits, result, maps, temp + letters.charAt(i), index+1);
		}
	}
	
	public static void main(String[] args) {
		LetterCombinationsofaPhoneNumber instance = new LetterCombinationsofaPhoneNumber();
		System.out.println(Arrays.toString(instance.letterCombinations("2").toArray()));
	}
}
