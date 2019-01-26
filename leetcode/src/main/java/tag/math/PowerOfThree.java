package tag.math;

/**
 * 
 * Given an integer, write a function to determine if it is a power of three.
 * 
 * Follow up: Could you do it without using any loop / recursion?
 * 
 * @author bliu13 Jan 12, 2016
 */
public class PowerOfThree {
	public boolean isPowerOfThree(int n) {
		if (n <= 0) {
			return false;
		}

		while (n % 3 == 0) {
			n = n / 3;
		}

		return n == 1;
	}
}
