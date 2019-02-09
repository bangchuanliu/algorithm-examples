package tag.string;

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
		int[] nums = {1,3,4,2,2};
		int low = 0;
        int high = 5;
		int mid = (int) (low + (high - low) * 0.5);
		System.out.println(mid);
		FindtheDuplicateNumber instance = new FindtheDuplicateNumber();
		System.out.println(instance.findDuplicate(nums));
	}
}
