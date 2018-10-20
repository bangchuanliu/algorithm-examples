package leetcode.dp;


public class Factorial {

	public int compute(int n) {
		if (n < 0) {
			return 0;
		} else if (n == 0 || n == 1) {
			return 1;
		} else {
			return compute(n - 1) * n;
		}
	}

	public int compute2(int n) {
		if (n < 0){
			return 0;
		}else if (n == 0) {
			return 1;
		} else {
			int[] f = new int[n+1];
			f[0] = 1;
			for (int i = 1; i <= n; i++) {
				f[i] = i * f[i-1];
			}
			return f[n];
		}
	}

	public static void main(String[] args) {
//		System.out.println(new Factorial().compute(111111111));
		System.out.println(new Factorial().compute2(5));
	}
}
