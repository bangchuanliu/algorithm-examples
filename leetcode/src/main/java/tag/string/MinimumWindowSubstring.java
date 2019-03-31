package tag.string;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

    public String minWindow(String s, String t) {
        Map<Character, Integer> tmap = new HashMap<>();
        Map<Character, Integer> smap = new HashMap<>();

        int i = 0;
        int j = 0;

        int[] result = {-1, 0, 0};

        for (int k = 0; k < t.length(); k++) {
            tmap.put(t.charAt(k), tmap.getOrDefault(t.charAt(k), 0) + 1);
        }

        int tSize = tmap.size();
        int sSize = 0;

        while (j < s.length()) {
            char c = s.charAt(j);
            smap.put(c, smap.getOrDefault(c, 0) + 1);

            if (tmap.containsKey(c) && tmap.get(c).equals(smap.get(c))) {
                sSize++;
            }

            while (i <= j && sSize == tSize) {
                if (result[0] == -1 || j - i + 1 < result[0]) {
                    result[0] = j - i + 1;
                    result[1] = i;
                    result[2] = j;
                }

                char ch = s.charAt(i);
                smap.put(ch, smap.get(ch) - 1);
                if (tmap.containsKey(ch) && tmap.get(ch).intValue() > smap.get(ch).intValue()) {
                    sSize--;
                }
                i++;
            }

            j++;
        }

        return result[0] == -1 ? "" : s.substring(result[1], result[2] + 1);
    }

    public static void main(String[] args) {
        MinimumWindowSubstring minimumWindowSubstring = new MinimumWindowSubstring();
        System.out.println(minimumWindowSubstring.minWindow("ADOBECODEBANC", "ABC"));
    }
}
