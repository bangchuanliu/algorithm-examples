package tag.dp;

public class NRank {

    // i - number of people
    // j - number of ranks
    // add 1 new person
    // case 1: rank is one of existing ranks,
    // case 2: rank is new
    public int ranks(int N) {
        int[][] dp = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            dp[i][1] = 1;
        }

        for (int i = 2; i <= N; i++) {
            for (int j = 2; j <= i; j++) {
                dp[i][j] = j * dp[i - 1][j] + j * dp[i - 1][j - 1];
            }
        }

        int count = 0;

        for (int i = 1; i <= N; i++) {
            count += dp[N][i];
        }

        return count;
    }


    public int solve(int A) {
        int[][] dp = new int[A + 1][A + 1];
        int[] fact = new int[A + 1];
        for (int i = 1; i <= A; i++) {
            fact[i] = i == 1 ? 1 : (fact[i - 1] * i);
        }
        for (int i = 1; i <= A; i++)
            for (int j = i; j <= A; j++) {
                if (i == j) dp[i][j] = fact[i];
                else if (i == 1) dp[i][j] = 1;
                else dp[i][j] = i * dp[i][j - 1] + i * dp[i - 1][j - 1];
            }
        int ret = 0;
        for (int i = 1; i <= A; i++)
            ret += dp[i][A];
        return ret;
    }
    
    public static void main(String[] args) {
        NRank rank = new NRank();
        
        System.out.println(rank.ranks(11) + " " + rank.solve(11));
        System.out.println(rank.ranks(2) + " " + rank.solve(2));
        System.out.println(rank.ranks(3) + " " + rank.solve(3));
        System.out.println(rank.ranks(4) + " " + rank.solve(4));
        System.out.println(rank.ranks(5) + " " + rank.solve(5));
        System.out.println(rank.ranks(6) + " " + rank.solve(6));
    }
}
