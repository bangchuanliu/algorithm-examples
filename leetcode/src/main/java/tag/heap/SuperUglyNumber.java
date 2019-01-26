
package tag.heap;

import java.util.PriorityQueue;

/**
 * 
 * 
 * @author bliu13 Dec 10, 2015
 */
public class SuperUglyNumber {
	public int nthSuperUglyNumber(int n, int[] primes) {
		if (n <= 0 || primes == null || primes.length == 0) {
			return 0;
		}

		long[] uglyNumbers = new long[n + 1];
		uglyNumbers[1] = 1;
		PriorityQueue<Long> heap = new PriorityQueue<>();

		for (int prime : primes) {
			heap.offer((long)prime);
		}

		for (int i = 2; i <= n; i++) {
			uglyNumbers[i] = heap.poll();
			for (int j = 0; j < primes.length; j++) {
				if (uglyNumbers[i] % primes[j] == 0) {
					heap.offer(uglyNumbers[i] * primes[j]);
					break;
				} else {
					heap.offer(uglyNumbers[i] * primes[j]);
				}
			}
		}

		return (int)uglyNumbers[n];
	}

	public static void main(String[] args) {
		SuperUglyNumber instance = new SuperUglyNumber();
		int[] primes = {5,7,13,17,23,29,31,43,53,59,61,71,73,79,83,97,109,131,137,163,167,181,191,193,197,199,227,233,251,263};
//		int[] primes = {5,17,19,23,47,53,59,61,67,71,73,89,101,107,109,113,131,149,157,163,167,179,181,191,199,211,223,233,239,251};
//		int[] primes = {2,3,5,13,19,29,31,41,43,53,59,73,83,89,97,103,107,109,127,137,139,149,163,173,179,193,197,199,211,223,227,229,239,241,251,257,263,269,271,281,317,331,337,347,353,359,367,373,379,389,397,409,419,421,433,449,457,461,463,479,487,509,521,523,541,547,563,569,577,593,599,601,613,619,631,641,659,673,683,701,709,719,733,739,743,757,761,769,773,809,811,829,857,859,881,919,947,953,967,971};
		System.out.println(instance.nthSuperUglyNumber(500, primes));
	}
}
