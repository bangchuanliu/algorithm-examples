package tag.dp;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to <adjacent> numbers on the row below.
 * <p>
 * For example, given the following triangle
 * [
 * [2],
 * [3,4],
 * [6,5,7],
 * [4,1,8,3]
 * ]
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 * <p>
 * Note:
 * Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
 *
 * @author admin
 */
public class Triangle {

    /**
     * @param triangle
     * @return
     */
    public int minimumTotal(List<List<Integer>> triangle) {

        int rowSize = triangle.size();
        int[] dp = new int[rowSize];

        for (int i = 0; i < dp.length; i++) {
            dp[i] = triangle.get(rowSize - 1).get(i);
        }

        for (int i = rowSize - 2; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                dp[j] = triangle.get(i).get(j) + Math.min(dp[j], dp[j + 1]);
            }
        }

        return dp[0];
    }

    public int minimumTotal2(List<List<Integer>> triangle) {
        int[] dp = new int[triangle.size()];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = triangle.get(0).get(0);

        for (int i= 1; i < triangle.size(); i++) {
            List<Integer> row = triangle.get(i);
            int[] cur = new int[triangle.size()];
            Arrays.fill(cur, Integer.MAX_VALUE);
            for (int j = 0; j < row.size(); j++) {
                if (j == 0) {
                    cur[j] = dp[j] + row.get(j);
                } else {
                    cur[j] = Math.min(dp[j],dp[j-1]) + row.get(j);
                }
            }
            dp = cur;
        }

        int min = Integer.MAX_VALUE;

        for (int a : dp) {
            min = Math.min(a,min);
        }

        return min;
    }

    public static void main(String[] args) {
        Triangle t = new Triangle();
        Integer[] r1 = {2};
        Integer[] r2 = {3, 4};
        Integer[] r3 = {6, 5, 7};
        Integer[] r4 = {4, 1, 8,3};
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();
        triangle.add(new ArrayList(Arrays.asList(r1)));
        triangle.add(new ArrayList(Arrays.asList(r2)));
        triangle.add(new ArrayList(Arrays.asList(r3)));
        triangle.add(new ArrayList(Arrays.asList(r4)));
        System.out.println(t.minimumTotal2(triangle));
    }
}
