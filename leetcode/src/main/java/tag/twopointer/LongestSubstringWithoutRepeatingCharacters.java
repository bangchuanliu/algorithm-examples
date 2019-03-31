package tag.twopointer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Given a string, find the length of the longest substring without repeating characters. For example,
 * the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3.
 * For "bbbbb" the longest substring is "b", with the length of 1.
 *
 * @author admin
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();

        int i = 0;
        int j = 0;
        int max = 0;

        while (j < s.length()) {
            if (set.contains(s.charAt(j))) {
                set.remove(s.charAt(i));
                i++;
            } else {
                set.add(s.charAt(j));
                j++;
                max = Math.max(max, j - i);
            }
        }
        return max;
    }

    public int lengthOfLongestSubstring2(String s) {
        Map<Character, Integer> map = new HashMap<>();

        int i = 0;
        int j = 0;
        int max = 0;

        while (j < s.length()) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)) + 1, i);
            }
            max = Math.max(max, j - i + 1);
            map.put(s.charAt(j), j);
            j++;
        }
        return max;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters instance = new LongestSubstringWithoutRepeatingCharacters();
        String s = "abba";
        String ss = "bbbbbbbbb";
        System.out.println(instance.lengthOfLongestSubstring(s));
        System.out.println(instance.lengthOfLongestSubstring(ss));
    }
}
