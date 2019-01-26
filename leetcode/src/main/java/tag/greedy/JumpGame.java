package tag.greedy;


/**
 * 
 * 
 * @author bliu13 Dec 27, 2015
 */
public class JumpGame {

	public boolean canJump(int[] nums) {
		
		if (nums == null || nums.length == 0) {
			return false;
		}

		int index = nums.length - 2;

		while (index >= 0) {
			if (nums[index] == 0) {
				int i = index - 1;
				while (i >= 0 && nums[i] <= index - i) {
					i--;
				}
				
				if (i < 0) {
					return false; 
				} else {
					index = i - 1;
				}
			} else {
				index--;
			}
		}

		return true;
	}
	
	public static void main(String[] args) {
		JumpGame instnace = new JumpGame();
		int[] nums = {0,3,1,0,4,3,2,0,1};
		System.out.println(instnace.canJump(nums));
	}
}
