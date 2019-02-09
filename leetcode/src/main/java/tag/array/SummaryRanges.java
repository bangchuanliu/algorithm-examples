package tag.array;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        List<String> result = new ArrayList<>();

        int start = 0;
        int end = 1;

        while (end < nums.length) {
            if (nums[end] - nums[end - 1] != 1) {
                if (start == end - 1) {
                    result.add(nums[start] + "");
                } else {
                    result.add(nums[start] + "->" + nums[end - 1]);
                }
                start = end;
            }
            end++;
        }

        if (start == end - 1) {
            result.add(nums[start] + "");
        } else {
            result.add(nums[start] + "->" + nums[end - 1]);
        }

        return result;
    }
}
