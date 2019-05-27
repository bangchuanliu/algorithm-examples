package tag.twopointer;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class LongestSubstringwithAtMostTwoDistinctCharacters {
    
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        Map<Character, Integer> map = new HashMap<>();
        int max = 1;
        int i = 0;
        int j = 0;

        while (j < s.length()) {
            map.put(s.charAt(j), j++);
            while (map.size() > 2) {
                int min = Collections.min(map.values());
                map.remove(s.charAt(min));
                i = min + 1;
            }
            max = Math.max(max, j - i);
        }

        return max;
    }
}
