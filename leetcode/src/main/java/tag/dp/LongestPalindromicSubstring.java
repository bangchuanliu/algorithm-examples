package tag.dp;

/**
 * Given a string S, find the longest palindromic substring in S. You may assume
 * that the maximum length of S is 1000, and there exists one unique longest
 * palindromic substring.
 */
public class LongestPalindromicSubstring {

    public String longestPalindrome(String s) {
        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            int s1 = longestPalindrome(s, i, i);
            int s2 = longestPalindrome(s, i, i + 1);
            int len = Math.max(s1, s2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2 + 1;
            }
        }

        return s.substring(start, end);
    }


    public int longestPalindrome(String s, int i, int j) {
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        return j - i - 1;
    }


    public static void main(String[] args) {
        LongestPalindromicSubstring instance = new LongestPalindromicSubstring();
        System.out.println(instance.longestPalindrome("aabaa"));
        System.out.println(instance.longestPalindrome("aacdefg"));
        System.out.println(instance.longestPalindrome("acdefgg"));
        System.out.println(instance.longestPalindrome("acdedfghijk"));
        System.out.println(instance.longestPalindrome("acdefghijik"));
    }
}
