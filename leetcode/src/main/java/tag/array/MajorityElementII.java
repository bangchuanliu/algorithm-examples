package tag.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MajorityElementII {

    public List<Integer> majorityElement(int[] nums) {

        List<Integer> result = new ArrayList<>();

        int m1 = 0;
        int m2 = 0;
        int c1 = 0;
        int c2 = 0;
        for (int num : nums) {

            if (num == m1) {
                c1++;
            } else if (num == m2) {
                c2++;
            } else if (c1 == 0) {
                m1 = num;
                c1++;
            } else if (c2 == 0) {
                m2 = num;
                c2++;
            } else {
                c1--;
                c2--;
            }
        }

        c1 = 0;
        c2 = 0;
        for (int num : nums) {
            if (num == m1) {
                c1++;
            } else if (num == m2) {
                c2++;
            }
        }

        if (c1 > nums.length / 3) {
            result.add(m1);
        }

        if (c2 > nums.length / 3) {
            result.add(m2);
        }

        return result;
    }

    public static void main(String[] args) {
        MajorityElementII instance = new MajorityElementII();
        int[] nums = {1, 1, 1, 3, 3, 2, 2, 2};
        List<Integer> result = instance.majorityElement(nums);
        System.out.println(Arrays.toString(result.toArray()));
    }
}
