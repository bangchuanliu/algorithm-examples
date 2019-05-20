package tag.array;


import java.util.HashMap;
import java.util.Map;

/**
 * Given a list of non-negative numbers and a target integer k, write a function to check if the array has a continuous subarray of size at least 2 that sums up to the multiple of k, that is, sums up to n*k where n is also an integer.
 * <p>
 * Example 1:
 * <p>
 * Input: [23, 2, 4, 6, 7],  k=6
 * Output: True
 * Explanation: Because [2, 4] is a continuous subarray of size 2 and sums up to 6.
 * Example 2:
 * <p>
 * Input: [23, 2, 6, 4, 7],  k=6
 * Output: True
 * Explanation: Because [23, 2, 6, 4, 7] is an continuous subarray of size 5 and sums up to 42.
 */
public class ContinuousSubarraySum {

    /**
     * prefix sum
     */
    public boolean checkSubarraySum(int[] nums, int k) {
        int[] sum = new int[nums.length];

        sum[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i];
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int temp = sum[j] - sum[i] + nums[i];
                if (temp == k || (k != 0 && temp % k == 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    /**
     *  (a - b) mod k = 0 <==> a mod k == b mod k
     * 
     */
    public boolean checkSubarraySum2(int[] nums, int k) {
        Map<Integer, Integer> index = new HashMap<>();
        index.put(0, -1);

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if (k != 0) {
                sum = sum % k;
            }

            if (index.containsKey(sum)) {
                if (i - index.get(sum) > 1) {
                    return true;
                }
            } else {
                index.put(sum, i);
            }
        }

        return false;
    }
}
