package tag.array;

/**
 * 1. use hashmap to record num count
 * 2. use array to record num count, array index is num
 * 3. use one variable to record candidate
 */
public class MajorityElement {

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
