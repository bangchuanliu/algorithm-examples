package tag.array;


/**
 * @author bliu13 Dec 27, 2015
 * 
 * @version 2.0
 * @since Feb, 10, 2019
 */
public class JumpGame {

    public boolean canJump(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0) {
            if (nums[i] == 0) {
                int index = 1;
                i--;
                while (i >= 0 && nums[i] <= index++) {
                    i--;
                }
                if (i < 0) {
                    return false;
                }
            } else {
                i--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        JumpGame instnace = new JumpGame();
        int[] nums = {2, 0, 1, 0, 1};
        System.out.println(instnace.canJump(nums));
    }
}
