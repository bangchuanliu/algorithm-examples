package tag.array;

import java.util.Arrays;
import java.util.Random;

public class ShuffArray  {

    int[] a;
    int[] nums;
    Random ran = new Random();
    public ShuffArray(int[] nums) {
        a = new int[nums.length];
        this.nums = nums;
        System.arraycopy(nums, 0, a, 0, nums.length);
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        System.arraycopy(nums, 0, a, 0, nums.length);
        return a;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        for (int i = a.length - 1; i >= 0; i--) {
            int index = ran.nextInt(i+1);
            int temp = a[i];
            a[i] = a[index];
            a[index] = temp;
        }

        return a;
    }
    
    public static void main(String[] args) {
        int[] nums = new int[] {1,2,3};
        ShuffArray shuffArray = new ShuffArray(nums);
        System.out.println(Arrays.toString(shuffArray.shuffle()));
        System.out.println(Arrays.toString(shuffArray.reset()));
        System.out.println(Arrays.toString(shuffArray.shuffle()));
    }
}
