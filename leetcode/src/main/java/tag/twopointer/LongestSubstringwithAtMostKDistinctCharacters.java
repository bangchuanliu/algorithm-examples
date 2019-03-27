package tag.twopointer;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringwithAtMostKDistinctCharacters {

    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int max = 0;
        if (k == 0) {
            return max;
        }
        Map<Character, Integer> map = new HashMap<>();
        int i = 0;
        int j = i;

        while (j < s.length()) {
            map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0)+1);
            j++;
            while (map.size() > k) {
                int count = map.get(s.charAt(i));
                count--;
                if (count == 0) {
                    map.remove(s.charAt(i));    
                } else {
                    map.put(s.charAt(i),count);
                }
                i++;
            }

            max = Math.max(max, j - i);
        }
        return max;
    }

    public static void main(String[] args) {
        LongestSubstringwithAtMostKDistinctCharacters longestSubstringwithAtMostKDistinctCharacters = new LongestSubstringwithAtMostKDistinctCharacters();
        System.out.println(longestSubstringwithAtMostKDistinctCharacters.lengthOfLongestSubstringKDistinct("ccaabbb", 2));
        System.out.println(longestSubstringwithAtMostKDistinctCharacters.lengthOfLongestSubstringKDistinct("ab", 1));
    }
}
