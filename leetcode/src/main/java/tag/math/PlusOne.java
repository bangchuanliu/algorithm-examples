package tag.math;

/**
 * 
 * Given a non-negative number represented as an array of digits, plus one to
 * the number.
 * 
 * The digits are stored such that the most significant digit is at the head of
 * the list.
 * 
 * @author bliu13 Jan 13, 2016
 */
public class PlusOne {
	public int[] plusOne(int[] digits) {
		if (digits == null || digits.length == 0) {
			return digits;
		}

		int index = digits.length - 1;
		while (index >= 0) {
			if (digits[index] == 9) {
				digits[index] = 0;
			} else {
				digits[index] = digits[index] + 1;
				break;
			}
			index--;
		}
		if (index < 0) {
			int[] newDigits = new int[digits.length + 1];
			newDigits[0] = 1;
			return newDigits;
		} else {
			return digits;
		}
	}
}
