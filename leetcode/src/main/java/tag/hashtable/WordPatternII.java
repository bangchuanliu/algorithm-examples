package tag.hashtable;

import java.util.HashMap;
import java.util.Map;

public class WordPatternII {
    public boolean wordPatternMatch(String pattern, String str) {
        Map<Character, String> map = new HashMap<>();
        return wordPatternMatch(pattern,str,map);
    }

    public boolean wordPatternMatch(String pattern, String str, Map<Character, String> map) {
        if (pattern.isEmpty()) {
            return str.isEmpty();
        }
        if (map.containsKey(pattern.charAt(0))) {
            String temp = map.get(pattern.charAt(0));
            if (str.length() >= temp.length() && str.substring(0, temp.length()).equals(temp)) {
                return wordPatternMatch(pattern.substring(1),str.substring(temp.length()),map);
            }
        } else {
            for (int j = 1; j <= str.length(); j++) {
                if (!map.containsValue(str.substring(0, j))) {
                    map.put(pattern.charAt(0),str.substring(0,j));
                    if(wordPatternMatch(pattern.substring(1), str.substring(j),map)) {
                        return true;
                    }
                    map.remove(pattern.charAt(0));
                }
            }
            return false;
        }
        return false;
    }

    public static void main(String[] args) {
        WordPatternII instance = new WordPatternII();
        System.out.println(instance.wordPatternMatch("aabb", "xyzabcxzyabc"));
    }
}