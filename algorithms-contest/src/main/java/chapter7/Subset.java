package chapter7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subset {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> result = new ArrayList<>();
        Integer[] temp = new Integer[nums.length];
        subset2(nums, result, temp, 0, 0);

        System.out.println(Arrays.deepToString(result.toArray()));
    }

    public static void subset(int[] nums, List<List<Integer>> result, Integer[] temp, int index, int cur) {
        result.add(new ArrayList<>(Arrays.asList(Arrays.copyOfRange(temp, 0, cur))));

        for (int i = index; i < nums.length; i++) {
            temp[cur] = nums[i];
            subset(nums, result, temp, i + 1, cur + 1);
        }
    }

    public static void subset2(int[] nums, List<List<Integer>> result, Integer[] temp, int index, int cur) {
        if (index == nums.length) {
            result.add(new ArrayList<>(Arrays.asList(Arrays.copyOfRange(temp, 0, cur))));
        }

        subset(nums, result, temp, index + 1, cur);
        temp[cur] = nums[index];
        subset(nums, result, temp, index + 1, cur + 1);
        
    }
}
