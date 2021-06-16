package tag.array;

import java.util.ArrayList;
import java.util.List;

public class FindDisappearedNumbers {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();

        if(nums == null || nums.length == 0) {
            return result;
        }

        for(int num : nums) {
            int n = Math.abs(num);
            if(nums[n - 1] > 0) {
                nums[n - 1] = -nums[n - 1];
            }
        }

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > 0) {
                result.add(i+1);
            }
        }

        return result;
    }
}
