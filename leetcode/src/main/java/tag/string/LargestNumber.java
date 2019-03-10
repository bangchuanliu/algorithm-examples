package tag.string;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Given a list of non negative integers, arrange them such that they form the
 * largest number.
 * 
 * For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.
 * 
 * Note: The result may be very large, so you need to return a string instead of
 * an integer.
 * 
 * @author BangChuan Liu <liubangchuan1100@gmail.com>
 *
 * @date Feb 4, 2015
 */
public class LargestNumber {

	public static String largestNumber2(int[] num) {
		String[] strs = new String[num.length];
		for (int i = 0; i < num.length; i++) {
			strs[i] = String.valueOf(num[i]);
		}
		Arrays.sort(strs, (a,b) -> (b+a).compareTo(a+b));
		StringBuilder sb = new StringBuilder();
		for (String s : strs) {
			sb.append(s);
		}
		String str = sb.toString();
		int start = 0;
		while (start < str.length() && str.charAt(start) == '0') {
			start++;
		}
		return start == str.length() ? "0" : str.substring(start);
	}

	public static void main(String[] args) {
		int[] num = { 8247, 824 }; // 8248247
		int[] num2 = { 3, 30, 34, 5, 9 }; // 9534330
		int[] num3 = { 30, 3 }; // 330
		int[] num4 = { 1 }; // 1

		System.out.println(largestNumber2(num));
		System.out.println(largestNumber2(num2));
		System.out.println(largestNumber2(num3));
		System.out.println(largestNumber2(num4));
	}
}
