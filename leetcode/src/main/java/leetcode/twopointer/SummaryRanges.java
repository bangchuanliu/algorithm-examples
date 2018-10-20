package leetcode.twopointer;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
	public List<String> summaryRanges(int[] nums) {

		if (nums == null || nums.length == 0) {
			return new ArrayList<String>();
		}

		List<String> result = new ArrayList<>();

		int start = 0;
		int end = 1;

		while (end < nums.length) {
			if (nums[end] - nums[end - 1] != 1 || end == nums.length - 1) {
				if (start == end - 1) {
					result.add(nums[start] + "");
				} else {
					StringBuffer sb = new StringBuffer();
					sb.append(nums[start]);
					sb.append("->");
					sb.append(nums[end - 1]);
					result.add(sb.toString());
				}
				start = end;
			}
			end++;
		}

		if (start == end - 1) {
			result.add(nums[start] + "");
		} else {
			StringBuffer sb = new StringBuffer();
			sb.append(nums[start]);
			sb.append("->");
			sb.append(nums[end - 1]);
			result.add(sb.toString());
			start = end;
		}

		return result;
	}
}
