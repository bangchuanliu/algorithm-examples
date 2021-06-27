package tag.array;

/**
 * 169. Majority Element
 * <p>
 * Given an array nums of size n, return the majority element.
 * <p>
 * The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.
 * <p>
 * Input: nums = [3,2,3]
 * Output: 3
 * <p>
 * Input: nums = [2,2,1,1,1,2,2]
 * Output: 2
 */
public class MajorityElement {

    // The idea is that reduce number when there are different
    // The majority would be left
    public static int majorityElement(int[] nums) {
        int count = 0;
        int n = 0;

        for (int num : nums) {
            if (count == 0 || n == num) {
                n = num;
                count++;
            } else {
                count--;
            }
        }

        return n;
    }

    public static void main(String[] args) {
        int[] num = {3, 3, 4};
        System.out.println(majorityElement(num));
    }

}
