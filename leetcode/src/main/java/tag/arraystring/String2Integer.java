package tag.arraystring;

/**
 * 
 * Implement atoi to convert a string to an integer.
 * 
 * Hint: Carefully consider all possible input cases. If you want a challenge,
 * please do not see below and ask yourself what are the possible input cases.
 * 
 * Notes: It is intended for this problem to be specified vaguely (ie, no given
 * input specs). You are responsible to gather all the input requirements up
 * front.
 * 
 * @author admin
 *
 */
public class String2Integer {

	/**
	 * handle follow cases
	 * 
	 * 1. null or empty string 2. white spaces 3. +/- sign 4. calculate real
	 * value 5. handle min & max
	 */

	public int atoi(String str) {
		if (str == null || str.length() == 0) {
			return 0;
		}
		
		long num = 0;
		int left = 0;
		int right = str.length() - 1;
		int flag = 1;
		
		while (left <= right && str.charAt(left) == ' ') {
			left++;
		}
		
		if (left > right) {
			return 0;
		}
		
		while (right >= left && str.charAt(right) == ' ') {
			right--;
		}

		if (str.charAt(left) == '-' || str.charAt(left) == '+') {
			if (str.charAt(left) == '-') {
				flag = -1;
			}
			left++;
		}

		while (left <= right && Character.isDigit(str.charAt(left))) {
			num = num * 10 + str.charAt(left) - '0';
			if (num * flag > Integer.MAX_VALUE) {
				return Integer.MAX_VALUE;
			}
			if (num * flag < Integer.MIN_VALUE) {
				return Integer.MIN_VALUE;
			}

			left++;
		}
		num = num * flag;

		return (int) num;
	}

	public static void main(String[] args) {
		String2Integer instance = new String2Integer();
		System.out.println(instance.atoi("+1")); // 1
		System.out.println(instance.atoi("+-2")); // 0
	}
}
