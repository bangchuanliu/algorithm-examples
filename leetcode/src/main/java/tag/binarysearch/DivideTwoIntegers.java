package tag.binarysearch;

/**
 * 
 * @author bliu13 Jan 10, 2016
 */
public class DivideTwoIntegers {

	public int divide(int dividend, int divisor) {
		if (divisor == 0) {
			return Integer.MAX_VALUE;
		}

		if (divisor == -1 && dividend == Integer.MIN_VALUE) {
			return Integer.MAX_VALUE;
		}

		long dividendAbs = Math.abs((long) dividend);
		long divisorAbs = Math.abs((long) divisor);
		int result = 0;

		while (dividendAbs >= divisorAbs) {
			int numOfShifts = 0;

			while (dividendAbs >= (divisorAbs << numOfShifts)) {
				numOfShifts++;
			}

			result += 1 << (numOfShifts - 1);
			dividendAbs -= divisorAbs << (numOfShifts - 1);
		}

		if (dividend > 0 && divisor > 0 || dividend < 0 && divisor < 0) {
			return result;
		} else {
			return -result;
		}

	}

	public static void main(String[] args) {
		DivideTwoIntegers instance = new DivideTwoIntegers();
		System.out.println(instance.divide(-1010369383, -2147483648));
		System.out.println((1010369383 / 2147483648L));
	}

}
