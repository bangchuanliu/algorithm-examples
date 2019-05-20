package tag.twopointer;

import java.util.Arrays;

/**
 * Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
 * <p>
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 * <p>
 * For example,
 * Given input array A = [1,1,2],
 * <p>
 * Your function should return length = 2, and A is now [1,2].
 *
 */
public class RemoveDuplicatesfromSortedArray {
    public int removeDuplicates(int[] nums) {

        int i = 0;
        int j = 0;
       
        while (j < nums.length) {
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
            j++;
        }
        return i + 1;
    }

    public static void main(String[] args) {
        RemoveDuplicatesfromSortedArray instance = new RemoveDuplicatesfromSortedArray();
        int[] A = {-1, 0, 0, 0, 0, 3, 3};
        int len = instance.removeDuplicates(A);
        System.out.println(len);
        System.out.println(Arrays.toString(A));
    }
}
