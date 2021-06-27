package tag.binarysearch;

/**
 * 34. Find First and Last Position of Element in Sorted Array
 * 
 * Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
 *
 * If target is not found in the array, return [-1, -1].
 *
 * You must write an algorithm with O(log n) runtime complexity.
 * 
 */
public class FindFirstAndLastPositionOfElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = -1;
        result[1] = -1;

        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            int mid = (l + r) / 2;
            if (target == nums[mid]) {
                result[0] = mid;
                r = mid - 1;
            } else if (target < nums[mid]) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        l = 0;
        r = nums.length - 1;

        while (l <= r) {
            int mid = (l + r) / 2;
            if (target == nums[mid]) {
                result[1] = mid;
                l = mid + 1;
            } else if (target < nums[mid]) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return result;
    }
}
