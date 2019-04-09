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

        for (int i = 2; i < s.length(); i++) {
            for (int j = i - 2; j >= 0; j--) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[j][i] = dp[j + 1][i - 1] + 2;
                } else {
                    dp[j][i] = Math.max(dp[j + 1][i], dp[j][i - 1]);
                }
            }
        }

        return dp[0][s.length() - 1];
    }

    public static void main(String[] args) {
        LongestPalindromicSubsequence instance = new LongestPalindromicSubsequence();
        System.out.println(instance.longestPalindromeSubseq("aabaaba"));
    }
}
