package company.airbnb;

import java.util.Arrays;

public class WiggleSortII {

    public static void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int i = 0;
        int j = nums.length % 2 == 0 ? nums.length / 2 : (nums.length + 1) / 2;
        int[] result = new int[nums.length];

        for (int k = 0; k < nums.length; k++) {
            if (k % 2 == 0) {
                result[k] = nums[i++];
            } else {
                result[k] = nums[j++];
            }
        }
        for (int k = 0; k < nums.length; k++) {
            nums[k] = result[k];
        }

    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 5, 6};
        wiggleSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
