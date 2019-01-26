package tag.arraystring;

import java.util.HashMap;
import java.util.Map;

public class IntegerToEnglishWords {

	private static Map<Integer, String> numberWordMap = new HashMap<>();

	static {
		numberWordMap.put(0, "");
		numberWordMap.put(1, "One");
		numberWordMap.put(2, "Two");
		numberWordMap.put(3, "Three");
		numberWordMap.put(4, "Four");
		numberWordMap.put(5, "Five");
		numberWordMap.put(6, "Six");
		numberWordMap.put(7, "Seven");
		numberWordMap.put(8, "Eight");
		numberWordMap.put(9, "Nine");
		numberWordMap.put(10, "Ten");
		numberWordMap.put(11, "Eleven");
		numberWordMap.put(12, "Twelve");
		numberWordMap.put(13, "Thirteen");
		numberWordMap.put(14, "Fourteen");
		numberWordMap.put(15, "Fifteen");
		numberWordMap.put(16, "Sixteen");
		numberWordMap.put(17, "Seventeen");
		numberWordMap.put(18, "Eighteen");
		numberWordMap.put(19, "Nineteen");
		numberWordMap.put(20, "Twenty");
		numberWordMap.put(30, "Thirty");
		numberWordMap.put(40, "Forty");
		numberWordMap.put(50, "Fifty");
		numberWordMap.put(60, "Sixty");
		numberWordMap.put(70, "Seventy");
		numberWordMap.put(80, "Eighty");
		numberWordMap.put(90, "Ninety");
	}

	public String numberToWords(int num) {
		if (num < 0) {
			return null;
		}

		String temp = String.valueOf(num);
		while (temp.length() % 3 != 0) {
			temp = "0" + temp;
		}

		StringBuilder sb = new StringBuilder();
		if (temp.length() > 9) {
			if (!helper(temp.substring(0, 3)).equals("")) {
				sb.append(helper(temp.substring(0, 3))).append(" Billion ");
			}
			temp = temp.substring(3);
		}

		if (temp.length() > 6) {
			if (!helper(temp.substring(0, 3)).equals("")) {
				sb.append(helper(temp.substring(0, 3))).append(" Million ");
			}
			temp = temp.substring(3);
		}

		if (temp.length() > 3) {
			if (!helper(temp.substring(0, 3)).equals("")) {
				sb.append(helper(temp.substring(0, 3))).append(" Thousand ");
			}
			temp = temp.substring(3);
		}

		sb.append(helper(temp.substring(0, 3)));

		return sb.toString().equals("") ? "Zero" : sb.toString().trim();
	}

	public String helper(String str) {
		StringBuilder sb = new StringBuilder();

		if (str.charAt(0) != '0') {
			sb.append(numberWordMap.get(str.charAt(0) - '0')).append(" Hundred ");
		}

		int num = Integer.parseInt(str.substring(1));
		int num2 = 0;
		if (num >= 20) {
			num2 = num % 10;
			num = num / 10 * 10;
		}

		sb.append(numberWordMap.get(num));

		sb.append(" ").append(numberWordMap.get(num2));

		return sb.toString().trim();
	}

	public static void main(String[] args) {
		IntegerToEnglishWords ins = new IntegerToEnglishWords();
		System.out.println(ins.numberToWords(1000010));
	}
}
