package basic;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] nums = {4, 7, 1, 9, 2, 3};
        sort(nums, nums.length - 1, 0);

        System.out.println(Arrays.toString(nums));
    }

    public static void sort(int[] nums, int high, int low) {
        if (low == high) {
            return;
        }

        int mid = (high + low) / 2;
        sort(nums, high, mid + 1);
        sort(nums, mid, low);
        merge(nums, high, mid, low);
    }

    public static void merge(int[] nums, int high, int mid, int low) {
        int[] temp = new int[high - low + 1];

        int i = low;
        int j = mid + 1;

        for (int k = 0; k < temp.length; k++) {
            if (i > mid) {
                temp[k] = nums[j++];
            } else if (j > high) {
                temp[k] = nums[i++];
            } else if (nums[i] <= nums[j]) {
                temp[k] = nums[i++];
            } else {
                temp[k] = nums[j++];
            }
        }

        for (int k = 0; k < temp.length; k++) {
            nums[k + low] = temp[k];
        }
    }
}
