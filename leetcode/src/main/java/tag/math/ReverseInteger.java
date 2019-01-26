package tag.math;

/**
 * Reverse digits of an integer.
 * 
 * Example1: x = 123, return 321
 * 
 * Example2: x = -123, return -321
 * 
 * 
 * 
 * 
 * @author BangChuan Liu <liubangchuan1100@gmail.com>
 *
 * @date Oct 29, 2014
 */
public class ReverseInteger {

	public int reverse(int x) {
		long temp = 0;
		int num = x;

		while (num != 0) {
			temp = temp * 10 + num % 10;
			num = num / 10;
		}

		int result;

		if (x > 0 && temp > Integer.MAX_VALUE) {
			result = 0;
		} else if (x < 0 && temp < Integer.MIN_VALUE) {
			result = 0;
		} else {
			result = (int) temp;
		}

		return result;
	}

	public static void main(String[] args) {
		ReverseInteger rs = new ReverseInteger();
		System.out.println(rs.reverse(1534236469));
		System.out.println(rs.reverse(-123));
		System.out.println(9579836501L > Integer.MAX_VALUE);
	}
}
