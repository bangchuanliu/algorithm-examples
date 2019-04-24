package tag.math;

public class PrePermutations {
    
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        int i = nums.length - 2;

        while (i >= 0 && nums[i] <= nums[i+1]) {
            i--;
        }

        if (i >= 0) {
            int j = nums.length - 1;

            while (j >= 0 && nums[j] >= nums[i]) {
                j--;
            }

            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

        reverse(nums, i+1);
    }


    public void reverse(int[] nums, int start) {
        int i = start;
        int j = nums.length - 1;

        while (i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
}
