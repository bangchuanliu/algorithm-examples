package tag.binarysearch;

import java.util.TreeSet;

public class ContainsDuplicateIII {

	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		TreeSet<Long> set = new TreeSet<>();

		for (int i = 0; i < nums.length; i++) {
			Long successor = set.ceiling(Long.valueOf(nums[i]));
			Long pre = set.floor(Long.valueOf(nums[i]));

			if (successor != null && Math.abs(nums[i] - successor) <= t 
                    || pre != null && Math.abs(nums[i] - pre) <= t) {
			    return true;
            }
            set.add(Long.valueOf(nums[i]));
			
			if (i >= k) {
				set.remove(Long.valueOf(nums[i - k]));
			}
		}

		return false;
	}
	
	public static void main(String[] args) {
		ContainsDuplicateIII instance = new ContainsDuplicateIII();
		int[] nums = {1,0,1,1};
		System.out.println(instance.containsNearbyAlmostDuplicate(nums, 1, 2));
	}
}
