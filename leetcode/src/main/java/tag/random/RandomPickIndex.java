package tag.random;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class RandomPickIndex {

    private int[] nums;

    public RandomPickIndex(int[] nums) {
        this.nums = nums;
    }

    public int pick(int target) {
        int i = 0;
        int candidate = -1;
        int count = 0;
        while (i < nums.length) {
            if (nums[i] == target) {
                count++;
                double ran = Math.random();
                if (ran <= 1.0 / count) {
                    candidate = i;
                }
            }
            i++;
        }

        return candidate;
    }


    /**
     * HashMap
     */
    Map<Integer, List<Integer>> map;
    Random ran = new Random();

    public void Solution2(int[] nums) {
        map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            List<Integer> list = map.getOrDefault(nums[i], new ArrayList<>());
            list.add(i);
            map.put(nums[i], list);
        }
    }

    public int pick2(int target) {
        List<Integer> list = map.get(target);

        int index = ran.nextInt(list.size());

        return list.get(index);
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 3, 3};
        RandomPickIndex solution = new RandomPickIndex(nums);
        System.out.println(solution.pick(3));

    }
}
