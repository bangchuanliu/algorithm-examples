package tag.binarysearch;

import java.util.Set;
import java.util.TreeSet;

public class ContainsDuplicateIII {

	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		if (nums == null || nums.length == 0 || k < 1 || t < 0) {
			return false;
		}

		TreeSet<Long> set = new TreeSet<>();

		for (int i = 0; i < nums.length; i++) {
			long left = (long) nums[i] - t;
			long right = (long) nums[i] + t + 1;
			Set<Long> subset = set.subSet(left, right);

			if (!subset.isEmpty()) {
				return true;
			}

			set.add((long) nums[i]);

			if (i >= k) {
				set.remove((long) nums[i - k]);
			}
		}

		return false;
	}
	
	public static void main(String[] args) {
		ContainsDuplicateIII instance = new ContainsDuplicateIII();
		int[] nums = {1,3,1};
		System.out.println(instance.containsNearbyAlmostDuplicate(nums, 1, 1));
	}
}
