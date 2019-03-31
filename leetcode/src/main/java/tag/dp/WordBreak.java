package tag.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Given a string s and a dictionary of words dict, determine if s can be
 * segmented into a space-separated sequence of one or more dictionary words.
 * <p>
 * For example, given s = "leetcode", dict = ["leet", "code"].
 * <p>
 * Return true because "leetcode" can be segmented as "leet code".
 *
 * @author BangChuan Liu
 * @date 2015
 */
public class WordBreak {


    public boolean wordBreak(String s, List<String> wordDict) {
        if (s.isEmpty()) {
            return true;
        }

        for (String str : wordDict) {
            if (s.length() >= str.length() && s.substring(0, str.length()).equals(str)) {
                if (wordBreak(s.substring(str.length()), wordDict)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean wordBreakdp(String s, Set<String> dict) {
        boolean result[] = new boolean[s.length() + 1];
        result[0] = true;

        for (int i = 0; i < s.length(); i++) {
            if (!result[i]) {
                continue;
            }
            for (String word : dict) {
                int end = word.length() + i;
                if (end <= s.length() && !result[end] &&s.substring(i, end).equals(word)) {
                    result[end] = true;
                }
            }
        }
        return result[s.length()];
    }

    public static void main(String[] args) {
        WordBreak instance = new WordBreak();
        Set<String> dict = new HashSet<String>();
        dict.add("leet");
        dict.add("code");
        Map<String, Boolean> map = new HashMap<String, Boolean>();
        System.out.println(instance.wordBreakdp("aleetcode", dict));
        dict.clear();
        int i = 0;
        String str = "";
        while (i < 10) {
            str += "a";
            dict.add(str);
            i++;
        }
        String[] arr = new String[dict.size()];
        dict.toArray(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(instance.wordBreak(
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab",
                Arrays.asList(arr)));

        String[] strs = {"programcree", "program", "creek"};
        dict = new HashSet<String>(Arrays.asList(strs));
        System.out.println(instance.wordBreak("programcreek", Arrays.asList(strs)));
    }
}
