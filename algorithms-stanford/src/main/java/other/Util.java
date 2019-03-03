package other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Util {

    public static void main(String[] args) {
        Util util = new Util();
        int[] nums = {1,2,2};
        System.out.println(Arrays.deepToString(util.subsetsWithDup(nums).toArray()));


    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        subsetsWithDup(result, nums, 0, new ArrayList<>());
        return result;
    }

    public void subsetsWithDup(List<List<Integer>> result, int[] nums, int index, List<Integer> temp) {
//        if (index > nums.length) {
//            return;
//        }
        result.add(new ArrayList<>(temp));

        int last = Integer.MIN_VALUE;

        for (int i = index; i < nums.length; i++) {
            if (nums[i] != last) {
                last = nums[i];
                temp.add(nums[i]);
                subsetsWithDup(result, nums, i+1,temp);
                temp.remove(temp.size()-1);
            }
        }
    }
}
