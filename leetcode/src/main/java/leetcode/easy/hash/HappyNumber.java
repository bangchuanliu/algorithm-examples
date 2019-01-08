package leetcode.easy.hash;

import java.util.HashSet;
import java.util.Set;


/**
 * 
 * Write an algorithm to determine if a number is "happy".
 * 
 * A happy number is a number defined by the following process: Starting with
 * any positive integer, replace the number by the sum of the squares of its
 * digits, and repeat the process until the number equals 1 (where it will
 * stay), or it loops endlessly in a cycle which does not include 1. Those
 * numbers for which this process ends in 1 are happy numbers.
 * 
 * Example: 19 is a happy number
 * 
 * 1^2 + 9^2 = 82 
 * 8^2 + 2^2 = 68 
 * 6^2 + 8^2 = 100 
 * 1^2 + 0^2 + 0^2 = 1
 * 
 * 
 * @author bliu13 Jan 12, 2016
 */
public class HappyNumber {
	public boolean isHappy(int n) {
		if (n <= 0) {
			return false;
		}
		int m = n;
		int c = 0;
		while (m != 1 && c < 10000) {
			String str = String.valueOf(m);
			m = 0;
			for (int i = 0; i < str.length(); i++) {
				m += (str.charAt(i) - '0') * (str.charAt(i) - '0');
			}
			c++;
		}
		return c != 10000;
	}

	public boolean isHappy2(int n) {
		if (n <= 0) {
			return false;
		}

		Set<Integer> set = new HashSet<>();

		while (n != 1 && !set.contains(n)) {
			set.add(n);
			int temp = 0;
			while (n != 0) {
				temp = temp + (n % 10) * (n % 10);
				n = n / 10;
			}
			n = temp;
		}
		return n == 1;
	}

	public static void main(String[] args) {
		HappyNumber ins = new HappyNumber();
		System.out.println(ins.isHappy(19));
	}
}
