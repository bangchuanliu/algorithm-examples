package tag.array;

/**
 * Given a non-negative number represented as an array of digits, plus one to
 * the number.
 * <p>
 * The digits are stored such that the most significant digit is at the head of
 * the list.
 *
 * @author bliu13 Jan 13, 2016
 * @version 2.0 
 * @Since Feb 5, 2019
 */
public class PlusOne {
    public int[] plusOne(int[] digits) {
        int adv = 1;

        for (int i = digits.length - 1; i >= 0; i--) {
            int temp = digits[i];
            digits[i] = (temp + adv) % 10;
            adv = (temp + adv) / 10;
        }

        if (adv == 1) {
            int[] result = new int[digits.length + 1];
            System.arraycopy(digits, 0, result, 1, digits.length);
            result[0] = 1;
            return result;
        } else {
            return digits;
        }
    }
}
