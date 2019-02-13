package tag.dp;

/**
 * You are climbing a stair case. It takes n steps to reach to the top.
 * <p>
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can
 * you climb to the top?
 * 
 * @date Oct 30, 2014
 * @version 2.0
 * @since Feb, 10, 2019
 */
public class ClimbingStairs {

    public int climbStairs(int n) {
        int[] result = new int[n + 1];
        result[0] = 1;
        result[1] = 1;

        for (int i = 2; i <= n; i++) {
            result[i] = result[i - 1] + result[i - 2];
        }

        return result[n];
    }

    public int climbStairs2(int n) {
        if (n == 0 || n == 1) {
            return 1;
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
