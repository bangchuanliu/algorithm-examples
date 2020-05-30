package tag.hashtable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author bliu13 Jan 17, 2016
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();

        if (strs == null || strs.length == 0) {
            return result;
        }
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] strChars = str.toCharArray();
            Arrays.sort(strChars);
            String newStr = new String(strChars);
            if (!map.containsKey(newStr)) {
                map.put(newStr, new ArrayList<>());
            }
            map.get(newStr).add(str);
        }

        result.addAll(map.values());

        return result;
    }

    /**
     * aabc -> #2#1#1#0...#0 (26)
     */
    public List<List<String>> groupAnagrams2(String[] strs) {
        if (strs.length == 0) return new ArrayList();
        Map<String, List> ans = new HashMap<>();
        
        for (String s : strs) {
            int[] count = new int[26];
            for (char c : s.toCharArray()) count[c - 'a']++;

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 26; i++) {
//                sb.append('#');
                sb.append(count[i]);
            }
            String key = sb.toString();
            if (!ans.containsKey(key)) ans.put(key, new ArrayList());
            ans.get(key).add(s);
        }
        return new ArrayList(ans.values());
    }
    
    public static void main(String[] args) {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        GroupAnagrams instance = new GroupAnagrams();
        System.out.println(Arrays.deepToString(instance.groupAnagrams2(strs).toArray()));
    }
}
