package tag.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.
 *
 * Example 1:
 * Input:nums = [1,1,1], k = 2
 * Output: 2
 * Note:
 * The length of the array is in range [1, 20,000].
 * The range of numbers in the array is [-1000, 1000] and the range of the integer k is [-1e7, 1e7].
 * 
 */
public class SubarraySumEqualsK {

    /**
     * prefix sum
     * 
     * sums[0] + k imply sub array len = 1
     */
    public int subarraySum(int[] nums, int k) {
        int[] sums = new int[nums.length + 1];
        for (int i = 1; i < sums.length; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }

        Map<Integer,Integer> map = new HashMap<>();
        int count = 0;
        for (int i = 0; i < sums.length; i++) {
            if (map.containsKey(sums[i])) {
                count += map.get(sums[i]);
            }
            map.put(sums[i] + k, map.getOrDefault(sums[i] + k, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        SubarraySumEqualsK subarraySumEqualsK = new SubarraySumEqualsK();
        int[] nums = {0,0,0,0,0,0,0,0,0,0};
        System.out.println(subarraySumEqualsK.subarraySum(nums, 0));
    }

}
