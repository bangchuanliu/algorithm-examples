package tag.dp;

public class LongestPalindromicSubsequence {

    public int longestPalindromeSubseq(String s) {
        int[][] dp = new int[s.length()][s.length()];

        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = 1;
        }

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                dp[i - 1][i] = 2;
            } else {
                dp[i - 1][i] = 1;
            }
        }

        for (int j = 2; j < s.length(); j++) {
            int low = 0;
            int high = j;
            while (high < s.length()) {
                if (s.charAt(low) == s.charAt(high)) {
                    dp[low][high] = dp[low + 1][high - 1] + 2;
                } else {
                    dp[low][high] = Math.max(dp[low + 1][high], dp[low][high - 1]);
                }
                low++;
                high++;
            }
        }

        return dp[0][s.length() - 1];
    }

    public static void main(String[] args) {
        LongestPalindromicSubsequence instance = new LongestPalindromicSubsequence();
        System.out.println(instance.longestPalindromeSubseq("aabaaba"));
    }
}
