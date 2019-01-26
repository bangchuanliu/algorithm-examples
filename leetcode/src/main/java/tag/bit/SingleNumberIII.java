package tag.bit;

public class SingleNumberIII {
	
	public int[] singleNumber(int[] nums) {
		
		if (nums == null) {
			return new int[2];
		}
		
		int mask = 0;
		int[] result = new int[2];
		
		for (int num : nums) {
			mask ^= num;
		}
		
		mask &= ~(mask - 1); // find first 1 bit
		
		for (int num : nums) {
			if ((num & mask) == 0) {
				result[0] ^= num; 
			} else {
				result[1] ^= num;
			}
		}
		
		return result;
	}
}
