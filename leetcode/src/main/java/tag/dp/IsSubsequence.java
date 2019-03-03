package tag.dp;

public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        
        boolean[][] dp = new boolean[s.length() + 1][t.length() + 1];
        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = true;
        }
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= t.length(); j++) {
                if (s.charAt(i-1) == t.charAt(j-1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }

        return dp[s.length()][t.length()];
    }
    
    public static void main(String[] args) {
        IsSubsequence isSubsequence = new IsSubsequence();
        System.out.println(isSubsequence.isSubsequence("", "ahbgdc"));
        System.out.println(isSubsequence.isSubsequence("twn", "xtxwxn"));
    }
}
