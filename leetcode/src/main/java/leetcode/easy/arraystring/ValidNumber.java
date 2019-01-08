package leetcode.easy.arraystring;


/**
 * Test cases
 * 
 *  ". 1" , " 005047e+6"
 * 
 * @author bliu
 *
 */
public class ValidNumber {
	public boolean isValidNumber(String str) {
		if (str == null || str.length() == 0) {
			return false;
		}

		int start = 0;
		int end = str.length() - 1;
		while (start <= end && str.charAt(start) == ' ') {
			start++;
		}

		if (start > end) {
			return false;
		}

		while (end >= start && str.charAt(end) == ' ') {
			end--;
		}

		if (str.charAt(start) == '-' || str.charAt(start) == '+') {
			start++;
		}

		boolean dot = false;
		boolean number = false;
		boolean exp = false;

		while (start <= end) {
			if (str.charAt(start) == '.') {
				if (dot || exp) {
					return false;
				} else {
					dot = true;
				}
			} else if (Character.isDigit(str.charAt(start))) {
				number = true;
			} else if (str.charAt(start) == 'e' || str.charAt(start) == 'E') {
				if (exp || !number) {
					return false;
				} else {
					exp = true;
					number = false;
				}
			} else if (str.charAt(start) == '+' || str.charAt(start) == '-') {
				if (str.charAt(start - 1) != 'e' && str.charAt(start - 1) != 'E') {
					return false;
				}
			} else {
				return false;
			}
			start++;
		}

		return number;
	}
}
