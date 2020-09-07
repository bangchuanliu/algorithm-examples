package chapter7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationII {
    public static void main(String[] args) {
        int[] nums = {1,1,2};
        List<List<Integer>> result = new ArrayList<>();
        Integer[] temp = new Integer[nums.length];
        boolean[] vis = new boolean[nums.length];
        Arrays.sort(nums);
        perm(nums, vis, result, temp, 0);
        
        System.out.println(Arrays.deepToString(result.toArray()));
    }
    
    public static void perm(int[] nums, boolean[] vis, List<List<Integer>> result, Integer[] temp, int index) {
        if (index == nums.length) {
            result.add(new ArrayList(Arrays.asList(temp)));
            return;
        }
        
        int pre = -1;
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != pre && !vis[i]) {
                vis[i] = true;
                pre = nums[i];
                temp[index] = nums[i];
                perm(nums, vis, result, temp, index + 1);
                vis[i] = false;
            }
        }
    }
}
