package tag.array;


/**
 * @author bliu13 Dec 27, 2015
 * @version 2.0
 * @since Feb, 10, 2019
 */
public class JumpGame {

    // greedy find previous reachable index
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }

        int index = nums.length - 1;

        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] >= (index - i)) {
                index = i;
            }
        }

        return index == 0;
    }
    
    // check if 0 can be jumped over
    public boolean canJump2(int[] nums) {
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
