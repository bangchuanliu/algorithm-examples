package tag.string;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

    public String minWindow(String s, String t) {

        Map<Character, Integer> tmap = new HashMap<>();
        Map<Character, Integer> temp = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            tmap.put(t.charAt(i), tmap.getOrDefault(t.charAt(i), 0) + 1);
        }
        String result = "";
        int i = 0;
        while (i < s.length() && !tmap.containsKey(s.charAt(i))) {
            i++;
        }
        int j = i;
        while (i <= j && j < s.length()) {
            if (tmap.containsKey(s.charAt(j))) {
                temp.put(s.charAt(j), temp.getOrDefault(s.charAt(j), 0) + 1);
                while (isFound(tmap, temp)) {
                    if (result.isEmpty() || s.substring(i, j+1).length() < result.length()) {
                        result = s.substring(i,j+1);
                    }
                    temp.put(s.charAt(i), temp.getOrDefault(s.charAt(i), 0) - 1);
                    i++;
                    while (i < s.length() && !tmap.containsKey(s.charAt(i))) {
                        i++;
                    }
                }
            }
            j++;
        }

        return result;
    }


    public boolean isFound(Map<Character, Integer> tmap, Map<Character, Integer> temp) {
        if (tmap.size() != temp.size()) {
            return false;
        }

        for (Character c : tmap.keySet()) {
            if (!temp.containsKey(c) || temp.get(c) < tmap.get(c)) {
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        MinimumWindowSubstring minimumWindowSubstring = new MinimumWindowSubstring();
        System.out.println(minimumWindowSubstring.minWindow("ADOBECODEBANC","ABC"));
    }
}
