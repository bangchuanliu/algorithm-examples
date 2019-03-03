package tag.twopointer;

public class RemoveDuplicatesfromSortedArrayII {
	public int removeDuplicates(int[] nums) {
		if (nums == null || nums.length <= 2) {
			return nums.length;
		}
		int pre = 1;
		int curr = 2;
		while (curr < nums.length) {
			if (nums[curr] != nums[pre] || nums[curr] != nums[pre - 1]) {
				pre++;
				nums[pre] = nums[curr];
			} 
			curr++;
		}
		return pre + 1;
	}
	
	public static void main(String[] args) {
        RemoveDuplicatesfromSortedArrayII removeDuplicatesfromSortedArrayII = new RemoveDuplicatesfromSortedArrayII();
        int[] nums = {1,1,1,2,2,3};
        System.out.println(removeDuplicatesfromSortedArrayII.removeDuplicates(nums));
    }
}
