package tag.dp;

/**
 * You are climbing a stair case. It takes n steps to reach to the top.
 * 
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can
 * you climb to the top?
 * 
 * @author BangChuan Liu <liubangchuan1100@gmail.com>
 *
 * @date Oct 30, 2014
 */
public class ClimbingStairs {

	/**
	 * DP
	 * 
	 * @param n
	 * @return
	 */
	public int climbStairs(int n) {
		if (n <= 0) {
			return 0;
		}
		
		if (n == 1) {
			return 1;
		}
		
		if (n == 2) {
			return 2;
		}
		
		int[] result = new int[n+1];
		
		result[1] = 1;
		result[2] = 2;

		for (int i = 3; i <= n; i++) {
			result[i] = result[i-1] + result[i-2];
		}
		
		return result[n];
	}

	/**
	 * recrusion
	 * 
	 * @param n
	 * @return
	 */
	public int climbStairs2(int n) {
		if (n <= 0) {
			return 0;
		}
		if (n == 1) {
			return 1;
		}
		if (n == 2) {
			return 2;
		}
		return climbStairs2(n - 1) + climbStairs2(n - 2);
	}

	public static void main(String[] args) {
		System.out.println(new ClimbingStairs().climbStairs(3));
		System.out.println(new ClimbingStairs().climbStairs2(3));
		System.out.println(new ClimbingStairs().climbStairs(44));
		System.out.println(new ClimbingStairs().climbStairs2(44));
	}
}
