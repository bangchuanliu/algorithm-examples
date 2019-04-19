package tag.hashtable;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {

    // sums[0] + k imply sub array len = 1
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
