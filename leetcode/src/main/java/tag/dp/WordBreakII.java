package tag.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given a string s and a dictionary of words dict,
 * add spaces in s to construct a sentence where each word is a valid dictionary word.
 * <p>
 * Return all such possible sentences.
 * <p>
 * For example, given
 * s = "catsanddog",
 * dict = ["cat", "cats", "and", "sand", "dog"].
 * <p>
 * A solution is ["cats and dog", "cat sand dog"].
 *
 * @author BangChuan Liu
 * @date 2015
 * @Contact liubangchuan1100@gmail.com
 */
public class WordBreakII {

    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> result = new ArrayList<String>();
        dfs(wordDict, result, "", s);
        return result;
    }


    public List<String> dp(String s, List<String> wordDict) {
        List<String>[] dp = new List[s.length() + 1];
        List<String> initial = new ArrayList<>();
        initial.add("");
        dp[0] = initial;

        for (int i = 0; i < s.length(); i++) {
            for (String str : wordDict) {
                int len = str.length();
                if (i + len <= s.length() && str.equals(s.substring(i, i + len))) {
                    List<String> temp = dp[i];
                    List<String> list = dp[i + len] == null ? new ArrayList<>() : dp[i+len];
                    if (temp != null && !temp.isEmpty()) {
                        for (String st : temp) {
                            list.add(st + " " + str);
                        }
                    }
                    dp[i + len] = list;
                }
            }
        }

        return dp[s.length()];
    }

    /**
     * backtracking
     */
    public void dfs(List<String> wordDict, List<String> ret, String tmp, String s) {
        if (s.isEmpty()) {
            ret.add(tmp.trim());
            return;
        }
        for (String str : wordDict) {
            if (str.length() <= s.length() && str.equals(s.substring(0, str.length()))) {
                dfs(wordDict, ret, tmp + " " + str, s.substring(str.length()));
            }
        }
    }

    public static void main(String[] args) {
        WordBreakII instance = new WordBreakII();
        String s = "pineapplepenapple";
        String[] strs = {"apple", "pen", "applepen", "pine", "pineapple"};
        List<String> dict = new ArrayList<>(Arrays.asList(strs));
        List<String> ret = instance.dp(s, dict);
        System.out.println(Arrays.toString(ret.toArray()));

    }
}
