package leetcode.arraystring;

public class ZigZagConversion {
	public String convert(String s, int numRows) {
		if (s == null || s.length() == 0 || numRows <= 1) {
			return s;
		}

		String result[] = new String[numRows];
		for (int i = 0; i < numRows; i++) {
			result[i] = "";
		}

		int gap = numRows - 2;
		int i = 0;
		while (i < s.length()) {
			for (int j = 0; i < s.length() && j < numRows; j++) {
				result[j] += s.charAt(i);
				i++;
			}

			for (int j = gap; i < s.length() && j > 0; j--) {
				result[j] += s.charAt(i);
				i++;
			}
		}

		String zigZagStr = "";
		for (String str : result) {
			zigZagStr += str;
		}

		return zigZagStr;
	}

	public static void main(String[] args) {
		ZigZagConversion ins = new ZigZagConversion();
		System.out.println(ins.convert("PAYPALISHIRING", 3));
	}
}
