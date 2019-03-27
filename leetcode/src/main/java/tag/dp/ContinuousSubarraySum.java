package tag.dp;

public class ContinuousSubarraySum {

    public boolean checkSubarraySum(int[] nums, int k) {
        int[] sum = new int[nums.length + 1];
        for (int i = 1; i < sum.length; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }

        for (int i = 0; i < sum.length; i++) {
            for (int j = i + 2; j < sum.length; j++) {
                int summ = sum[j] - sum[i];
                if (summ == k || (k != 0 && summ % k == 0)) {
                    return true;
                }
            }
        }

        return false;
    }
}
