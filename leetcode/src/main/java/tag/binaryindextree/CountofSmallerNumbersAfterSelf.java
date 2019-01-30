package tag.binaryindextree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

public class CountofSmallerNumbersAfterSelf {

    public List<Integer> countSmaller(int[] nums) {
        
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        
        TreeMap<Integer, Integer> map = new TreeMap<>();
        List<Integer> result = new ArrayList<>();
        result.add(0);
        map.put(nums[nums.length - 1],1);

        for (int i = nums.length - 2; i >= 0; i--) {
            Integer num = map.lowerKey(nums[i]);
            result.add(0, count(num, map));
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i],1);
            }
        }

        return result;
    }

    public int count(Integer num, TreeMap<Integer, Integer> map) {
        int count = 0;
        while (num != null) {
            count += map.get(num);
            num = map.lowerKey(num);
        }
        return count;
    }
    public static void main(String[] args) {
//        int[] nums = {0, 9, 5, 7, 3};
        // [10,27,10,35,12,22,28,8,19,2,12,2,9,6,12,5,17,9,19,12,14,6,12,5,12,3,0,10,0,7,8,4,0,0,4,3,2,0,1,0]
        int[] nums = {26,78,27,100,33,67,90,23,66,5,38,7,35,23,52,22,83,51,98,69,81,32,78,28,94,13,2,97,3,76,99,51,9,21,84,66,65,36,100,41};
        CountofSmallerNumbersAfterSelf instance = new CountofSmallerNumbersAfterSelf();
        List<Integer> result = instance.countSmaller(nums);
        
        System.out.println(Arrays.toString(result.toArray()));
    }
}
