package leetcode.math;

/**
 * Given a column title as appear in an Excel sheet, return its corresponding
 * column number.
 * 
 * For example:
 * 
 * A -> 1 B -> 2 C -> 3 ... Z -> 26 AA -> 27 AB -> 28
 * 
 * 
 * 
 * @author BangChuan Liu <liubangchuan1100@gmail.com>
 *
 * @date Jan 27, 2015
 */
public class ExcelSheetColumnNumber {

	public static int titleToNumber(String s) {
		if (s == null || s == "") {
			return 0;
		}

		int sum = 0;

		for (int i = 0; i < s.length(); i++) {
			sum = sum * 26 + s.charAt(i) - 'A' + 1;
		}

		return sum;
	}

	public static void main(String[] args) {
		System.out.println(titleToNumber("AA"));
		System.out.println((int) 'A');
	}
}
