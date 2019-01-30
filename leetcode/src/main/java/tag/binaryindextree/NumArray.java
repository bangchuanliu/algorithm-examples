package tag.binaryindextree;

public class NumArray {
    int[] block;
    int[] nums;
    int blockLen;

    public NumArray(int[] nums) {
        if (nums != null && nums.length > 0) {
            this.nums = nums;
            int len = nums.length;
            blockLen = new Double(Math.floor(Math.sqrt(len))).intValue();
            block = new int[len / blockLen + 1];
            int i = 0;

            while (i < nums.length) {
                block[i / blockLen] += nums[i];
                i++;
            }
        }
    }

    public void update(int i, int val) {
        int blockNum = i / blockLen;
        block[blockNum] = block[blockNum] - nums[i] + val;
        nums[i] = val;
    }

    public int sumRange(int i, int j) {
        int num1 = i / blockLen;
        int num2 = j / blockLen;
        int sum = 0;
        if (num1 == num2) {
            for (int k = i; k <= j; k++) {
                sum += nums[k];
            }
            return sum;
        } else {
            for (int k = i; k < (num1 + 1) * blockLen; k++) {
                sum += nums[k];
            }

            for (int k = num1 + 1; k < num2; k++) {
                sum += block[k];
            }

            for (int k = num2 * blockLen; k <= j; k++) {
                sum += nums[k];
            }
        }
        return sum;
    }

    public static void main(String[] args) {
//        int[] nums = {0, 9, 5, 7, 3};
        int[] nums = {-28, -39, 53, 65, 11, -56, -65, -39, -43, 97};
        NumArray numArray = new NumArray(nums);
//        System.out.println(numArray.sumRange(4, 4));
//        System.out.println(numArray.sumRange(2, 4));
//        System.out.println(numArray.sumRange(3, 3));
//
//        numArray.update(4, 5);
//        numArray.update(1, 7);
//        numArray.update(0, 8);
//        System.out.println(numArray.sumRange(1, 2));
//        numArray.update(1, 9);
//        System.out.println(numArray.sumRange(4, 4));
//        numArray.update(3, 4);

        System.out.println(numArray.sumRange(5, 6));
        numArray.update(9, 27);
        System.out.println(numArray.sumRange(2, 3));
        System.out.println(numArray.sumRange(6, 7));
    }
}
