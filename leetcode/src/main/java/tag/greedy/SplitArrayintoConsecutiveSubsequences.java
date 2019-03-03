package tag.greedy;

import java.util.HashMap;
import java.util.Map;

public class SplitArrayintoConsecutiveSubsequences {
    public boolean isPossible(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        Map<Integer, Integer> tails = new HashMap<>();

        for (int x : nums) {
            count.put(x, count.getOrDefault(x, 0) + 1);
        }

        for (int x : nums) {
            if (count.get(x) == 0) {
                continue;
            } else if (tails.get(x) != null && tails.get(x) > 0) {
                tails.put(x, tails.get(x) - 1);
                tails.put(x + 1, tails.getOrDefault(x + 1, 0) + 1);
            } else if (count.get(x + 2) != null && count.get(x + 1) != null && count.get(x + 1) > 0 && count.get(x + 2) > 0) {
                count.put(x + 1, count.get(x + 1) - 1);
                count.put(x + 2, count.get(x + 2) - 1);
                tails.put(x + 3, tails.getOrDefault(x + 3, 0) + 1);
            } else {
                return false;
            }
            count.put(x, count.get(x) - 1);
        }

        return true;
    }
}
