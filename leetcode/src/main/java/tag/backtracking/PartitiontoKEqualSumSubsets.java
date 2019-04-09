package tag.backtracking;

import java.util.Arrays;

public class PartitiontoKEqualSumSubsets {
    
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = Arrays.stream(nums).sum();

        if (sum % k != 0) {
            return false;
        }

        int target = sum / k;

        Arrays.sort(nums);

        int j = nums.length-1;

        while (j >= 0 && nums[j] == target) {
            j--;
            k--;
        }

        int[] group = new int[k];

        return helper(nums, target, j, group);
    }


    public boolean helper(int[] nums, int target, int j, int[] group) {
        if (j < 0) {
            return true;
        }

        for (int i = 0; i < group.length; i++) {
            if (group[i] + nums[j] <= target) {
                group[i] += nums[j];

                if (helper(nums, target, j - 1, group)) {
                    return true;
                }
                group[i] -= nums[j];
            }
        }

        return false;
    }
}
