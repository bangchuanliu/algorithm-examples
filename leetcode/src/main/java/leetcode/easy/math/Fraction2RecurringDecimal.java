package leetcode.easy.math;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author BangChuan Liu
 * @date 2015
 * @Contact liubangchuan1100@gmail.com
 */
public class Fraction2RecurringDecimal {

	public String fractionToDecimal(int numerator, int denominator) {
		if (denominator == 0) {
			return "0";
		}
		String ret = String.valueOf((double) numerator / denominator);
		if (ret.indexOf(".") > 0) {
			String[] array = ret.split("\\.");
			String integer = array[0];
			String fraction = array[1];
			String repeat = checkRepeat(fraction);
			if(repeat != null){
				return integer + "." + "(" + repeat+")";
			}
		}
		return ret;
	}

	private String checkRepeat(String str) {
		if(str.length() < 2){
			return null;
		}
		int step = 1;
		while (step <= str.length()) {
			Set<String> set = new HashSet<String>();
			set.add(str.substring(0, step));
			int j = step;
			while (j < str.length()
					&& set.contains(str.substring(j, Math.min(j + step, str.length())))) {
				j = j + step;
			}
			if (j == str.length()) {
				return set.iterator().next();
			}
			step++;
		}
		return null;
	}

	public static void main(String[] args) {
		Fraction2RecurringDecimal instance = new Fraction2RecurringDecimal();
		System.out.println(instance.fractionToDecimal(2, 3));
		System.out.println(instance.fractionToDecimal(2, 1));
		System.out.println(instance.fractionToDecimal(1, 2));
		System.out.println(instance.checkRepeat("66666666666666"));
		System.out.println(instance.checkRepeat("0101010101"));
		System.out.println(instance.checkRepeat("201201201"));
	}
}
