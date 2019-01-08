package leetcode.easy.arraystring;

public class FindtheDuplicateNumber {
	public int findDuplicate(int[] nums) {
		int low = 1, high = nums.length - 1;
		while (low <= high) {
			int mid = (int) (low + (high - low) * 0.5);
			int cnt = 0;
			for (int a : nums) {
				if (a <= mid)
					++cnt;
			}
			if (cnt <= mid)
				low = mid + 1;
			else
				high = mid - 1;
		}
		return low;
	}
	
	public static void main(String[] args) {
		int[] nums = {1,1,1,2,3,4,5,6};
		
		FindtheDuplicateNumber instance = new FindtheDuplicateNumber();
		System.out.println(instance.findDuplicate(nums));
	}
}
