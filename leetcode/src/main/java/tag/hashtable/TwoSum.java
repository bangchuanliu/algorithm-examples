package tag.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * @author bliu13
 * Nov 25, 2015
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> numsMap = new HashMap<>();
        int[] index = new int[2];

        for (int i = 0; i < nums.length; i++) {
            if (numsMap.containsKey(nums[i])) {
                index[0] = numsMap.get(nums[i]);
                index[1] = i;
                return index;
            } else {
                numsMap.put(target - nums[i], i);
            }
        }

        return index;
    }
}
