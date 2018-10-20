package leetcode.dp;

/**
 * 
 * @author bliu13 Dec 10, 2015
 */
public class UglyNumberII {
	public int nthUglyNumber(int n) {

		if (n <= 0) {
			return 0;
		}

		int[] uglyNumbers = new int[n + 1];
		uglyNumbers[1] = 1;

		int indexFor2 = 0;
		int indexFor3 = 0;
		int indexFor5 = 0;

		for (int i = 2; i <= n; i++) {
			int num1 = uglyNumbers[indexFor2] * 2;
			int num2 = uglyNumbers[indexFor3] * 3;
			int num3 = uglyNumbers[indexFor5] * 5;

			uglyNumbers[i] = Math.min(num3, Math.min(num1, num2));

			if (uglyNumbers[i] == num1) {
				indexFor2++;
			}

			if (uglyNumbers[i] == num2) {
				indexFor3++;
			}

			if (uglyNumbers[i] == num3) {
				indexFor5++;
			}
		}

		return uglyNumbers[n];
	}
}
