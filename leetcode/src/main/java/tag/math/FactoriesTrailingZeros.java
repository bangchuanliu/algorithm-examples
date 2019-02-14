package tag.math;

public class FactoriesTrailingZeros {

	/**
	 * final optimize
	 * 
	 * @param n
	 * @return
	 */
	public static int trailingZeroes(int n) {
		if (n <= 0) {
			return 0;
		}
		int count = 0;
		long j = 5;
		while (j <= n) {
			count += n / j;
			j *= 5;
		}
		return count;
	}

	public static void main(String[] args) {
		System.out.println(trailingZeroes(0));
		System.out.println(trailingZeroes(-1));
		System.out.println(trailingZeroes(105));
		System.out.println(trailingZeroes(625));
		System.out.println(trailingZeroes(1808548329));
		System.out.println(trailingZeroes(2147483647));
		System.out.println(0 % 5);
		System.out.println(0 / 5);

	}
}
