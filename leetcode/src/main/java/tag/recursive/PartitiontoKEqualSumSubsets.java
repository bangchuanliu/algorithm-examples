package tag.recursive;

import java.util.Arrays;

public class PartitiontoKEqualSumSubsets {

    public boolean search(int[] group, int row, int[] nums, int target) {
        if (row < 0) {
            return true;
        }
        int num = nums[row];
        for (int i = 0; i < group.length; i++) {
            if (group[i] + num <= target) {
                group[i] += num;
                if (search(group, row - 1, nums, target)) {
                    return true;
                }
                group[i] -= num;
            }
            if (group[i] == 0) {
                break;
            }
        }

        return false;
    }


    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = Arrays.stream(nums).sum();
        if (sum % k > 0) return false;
        int target = sum / k;

        Arrays.sort(nums);
        int row = nums.length - 1;
        if (nums[row] > target) return false;
        while (row >= 0 && nums[row] == target) {
            row--;
            k--;
        }
        return search(new int[k], row, nums, target);
    }
    
    public static void main(String[] args) {
        PartitiontoKEqualSumSubsets instance = new PartitiontoKEqualSumSubsets();
        int[] nums = {};
        instance.canPartitionKSubsets(nums, 3);
    }
}
