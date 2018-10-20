package leetcode.arraystring;

/**
 * 
 * @author bliu13 Nov 21, 2015
 */
public class CountPrimes {
	public int countPrimes(int n) {
		if (n <= 0) {
			return 0;
		}

		boolean[] isPrime = new boolean[n];

		for (int i = 2; i < n; i++) {
			isPrime[i] = true;
		}

		int count = 0;

		for (int i = 2; i * i < n; i++) {
			if (isPrime[i]) {
				for (int j = i * i; j < n; j += i) {
					isPrime[j] = false;
				}
			}
		}

		for (int i = 0; i < n; i++) {
			if (isPrime[i]) {
				count++;
			}
		}

		return count;
	}
}
