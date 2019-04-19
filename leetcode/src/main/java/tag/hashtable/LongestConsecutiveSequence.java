package tag.hashtable;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int max = 0;
        int count = 0;

        for (int num : nums) {
            if (!set.contains(num - 1)) {
                count = 0;
                while (set.contains(num)) {
                    count++;
                    num++;
                }
            }
            max = Math.max(count, max);
        }

        return max;
    }
}
