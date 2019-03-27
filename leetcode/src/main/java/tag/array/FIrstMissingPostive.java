package tag.array;

public class FIrstMissingPostive {

    public int firstMissingPositive(int[] nums) {
        boolean isOne = false;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                isOne = true;
            }
        }
        if (!isOne) {
            return 1;
        }
        if (nums.length == 1) {
            return 2;
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0 || nums[i] > nums.length) {
                nums[i] = 1;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            int a = Math.abs(nums[i]);
            if (a == nums.length) {
                nums[0] = -Math.abs(nums[0]);
            } else {
                nums[a] = -Math.abs(nums[a]);
            }
        }
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > 0) {
                return i;
            }
        }
        if (nums[0] > 0) {
            return nums.length;
        }
        return nums.length + 1;
    }

    public static void main(String[] args) {
        FIrstMissingPostive fIrstMissingPostive = new FIrstMissingPostive();
        int[] nums = {3, 4, -1, 1};
        System.out.println(fIrstMissingPostive.firstMissingPositive(nums));
    }
}
