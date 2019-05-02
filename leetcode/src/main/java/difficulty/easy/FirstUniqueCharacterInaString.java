package difficulty.easy;

import java.util.HashMap;
import java.util.Map;


/**
 * Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
 *
 * Examples:
 *
 * s = "leetcode"
 * return 0.
 *
 * s = "loveleetcode",
 * return 2.
 * Note: You may assume the string contain only lowercase letters.
 * 
 */
public class FirstUniqueCharacterInaString {


    /**
     * two pass
     * @param s
     * @return
     */
    public int firstUniqChar(String s) {
        int[] count = new int[256];

        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i)]++;
        }

        for (int i = 0; i < s.length(); i++) {
            if (count[s.charAt(i)] == 1) {
                return i;
            }
        }
        return -1;
    }

    /**
     * one pass
     * @param s
     * @return
     */
    public int firstUniqChar2(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int index = 0;

        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
            while (index <= i && map.get(s.charAt(index)) > 1) {
                index++;
            }

        }

        return index == s.length() ? -1 : index;
    }
}
