package chapter7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutation {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        boolean[] vis = new boolean[nums.length];

        perm(nums, vis, result, temp);

        System.out.println(Arrays.deepToString(result.toArray()));

        Integer[] ret = new Integer[nums.length];
        result = new ArrayList<>();
        perm2(nums, vis, result, ret, 0);
        System.out.println(Arrays.deepToString(result.toArray()));
    }

    public static void perm(int[] nums, boolean[] vis, List<List<Integer>> result, List<Integer> temp) {
        if (temp.size() == nums.length) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!vis[i]) {
                temp.add(nums[i]);
                vis[i] = true;
                perm(nums, vis, result, temp);
                vis[i] = false;
                temp.remove(temp.size() - 1);
            }
        }
    }
    
    public static void perm2(int[] nums, boolean[] vis, List<List<Integer>> result, Integer[] temp, int index) {
        if (index == nums.length) {
            result.add(new ArrayList(Arrays.asList(temp)));
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (!vis[i]) {
                vis[i] = true;
                temp[index] = nums[i];
                perm2(nums, vis, result, temp, index + 1);
                vis[i] = false;
            }
        }
    }
}
