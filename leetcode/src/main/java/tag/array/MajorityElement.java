package tag.array;

/**
 * 1. use hashmap to record num count
 * 2. use array to record num count, array index is num
 * 3. use one variable to record candidate
 * 
 */
public class MajorityElement {

    public static int majorityElement(int[] nums) {
        int candidate = nums[0];
        int count = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == candidate) {
                count++;
            } else {
                count--;
                if (count == 0) {
                    candidate = nums[i];
                    count = 1;
                }
            }
        }

        return candidate;
    }

    public static void main(String[] args) {
        int[] num = {3, 3, 4};
        System.out.println(majorityElement(num));
    }

}
