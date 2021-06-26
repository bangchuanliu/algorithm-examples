package tag.string;

public class FindtheDuplicateNumber {
	
	//calculate the count of all numbers less than mid
	// if count > mid, shrink the range to 1..mid -1
	// if count <= mid, shrink the range to mid+1 .. high
	public int findDuplicate(int[] nums) {
		int low = 1, high = nums.length - 1;
		while (low <= high) {
			int mid = (high + low) / 2;
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
	
	//Floyd's tortoise and hare algorithm to detect cycle
	// tortoise f(x);
	// hare f(f(x))
	public int findDuplicatedNumber(int[] nums) {
		if (nums == null || nums.length <= 1) {
			return 0;
		}
		
		int tortoise = nums[nums[0]];
		int hare = nums[tortoise];
		
		while(hare != tortoise) {
			tortoise = nums[tortoise];
			hare = nums[nums[hare]];
		}
		
		tortoise = nums[0];
		while(tortoise != hare) {
			tortoise = nums[tortoise];
			hare = nums[hare];
		}
		
		return hare;
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
