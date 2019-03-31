package tag.dp;


/**
 * Find the contiguous subarray within an array (containing at least one number) which has the largest product.
 * <p>
 * For example, given the array [2,3,-2,4],
 * the contiguous subarray [2,3] has the largest product = 6.
 *
 * @author admin
 */
public class MaxSubProductArray {

    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int subMax = nums[0];
        int subMin = nums[0];
        int max = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int temp = subMax;

            subMax = Math.max(nums[i], Math.max(nums[i] * subMax, nums[i] * subMin));
            subMin = Math.min(nums[i], Math.min(nums[i] * temp, nums[i] * subMin));

            max = Math.max(max, subMax);
        }

        return max;
    }

    public static void main(String[] args) {
        MaxSubProductArray instance = new MaxSubProductArray();
        int[] arr = {2, 3, -2, 4};
        System.out.println(instance.maxProduct(arr));
    }
}
