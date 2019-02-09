package tag.twopointer;

/**
 * Given an array nums, write a function to move all 0's to the end of it while
 * maintaining the relative order of the non-zero elements.
 * <p>
 * For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums
 * should be [1, 3, 12, 0, 0].
 * <p>
 * Note: You must do this in-place without making a copy of the array. Minimize
 * the total number of operations.
 *
 * @author bliu13 Jan 12, 2016
 */
public class MoveZeroes {

    /**
     * comparision is less
     */
    public void moveZeroes(int[] nums) {
        int i = 0;
        int j = i + 1;
        while (i < nums.length && j < nums.length) {
            if (nums[i] != 0) {
                i++;
                j = i + 1;
                continue;
            } else if (nums[j] == 0) {
                j++;
                continue;
            }

            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j++;
        }
    }

    /**
     * comparision is more
     * 
     */
    public void moveZeroes2(int[] nums) {
        int i = -1;
        int j = 0;

        while (j < nums.length) {
            if (nums[j] != 0) {
                i++;
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
            j++;
        }
    }


}
