package tag.string;

public class DistinctSubsequences {
    
    public int numDistinct(String s, String t) {
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 1;
        }
        
        for (int j = 1; j <= t.length(); j++) {
            for (int i = 1; i <= s.length(); i++) {
                if (s.charAt(i-1) == t.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j] + dp[i-1][j-1];
                } else {
                    dp[i][j] += dp[i-1][j];
                }
            } 
        }
        
        return dp[s.length()][t.length()];
    }

    public static void main(String[] args) {
        DistinctSubsequences distinctSubsequences = new DistinctSubsequences();
        System.out.println(distinctSubsequences.numDistinct("babgbag", "bag"));
    } 
}
