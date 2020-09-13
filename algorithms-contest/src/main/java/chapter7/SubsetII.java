package chapter7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetII {
    public static void main(String[] args) {

        int[] nums = {1,2,2};
        List<List<Integer>> result = new ArrayList();
        Integer[] temp = new Integer[nums.length];

        subsets(nums, result, temp, 0 ,0);

        System.out.println(Arrays.deepToString(result.toArray()));
    }

    public static void subsets(int[] nums, List<List<Integer>> result, Integer[] temp, int index, int cur) {
        result.add(new ArrayList(Arrays.asList(Arrays.copyOfRange(temp, 0, cur))));

        int pre = Integer.MIN_VALUE;

        for (int i = index; i < nums.length; i++) {
            if (pre != nums[i]) {
                pre = nums[i];
                temp[cur] = nums[i];
                subsets(nums, result, temp, i + 1, cur + 1);
            }
        }
    }
}
