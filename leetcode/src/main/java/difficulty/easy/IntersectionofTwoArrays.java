package difficulty.easy;

import java.util.HashSet;
import java.util.Set;

public class IntersectionofTwoArrays {

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();

        for (int num : nums1) {
            set.add(num);
        }

        Set<Integer> set2 = new HashSet<>();
        for (int num : nums2) {
            if (set.contains(num)) {
                set2.add(num);
            }
        }
        int[] result = new int[set2.size()];
        int i = 0;
        for (Integer num : set2) {
            result[i++] = num;
        }
        return result;
    }
}
