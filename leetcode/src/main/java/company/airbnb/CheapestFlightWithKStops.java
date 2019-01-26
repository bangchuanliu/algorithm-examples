package company.airbnb;

public class CheapestFlightWithKStops {

    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        int[] dp = new int[n];
        for (int i = 0; i < dp.length; i++) {
            if (src != i) {
                if (flights[src][i] != 0) {
                    dp[i] = flights[src][i];
                } else {
                    dp[i] = Integer.MAX_VALUE;
                }
            }
        }

        for (int i = 1; i <= K; i++) {
            int[] temp = new int[n];
            for (int j = 0; j < n; j++) {
                int min = Integer.MAX_VALUE;
                for (int x = 0; x < flights.length; x++) {
                    if (flights[x][j] != 0) {
                        min = Math.min(min, dp[x] + flights[x][j]);
                    }
                }
                temp[j] = Math.min(dp[j], min);
            }
            dp = temp;
        }

        return dp[dst] == Integer.MAX_VALUE ? -1 : dp[dst];
    }
    
    public static void main(String[] args) {
//        int[][] flights = {{0,100,500},{0,0,100},{0,0,0}};
        int[][] flights = {{0,1,100},{1,2,100},{0,2,500}};
        System.out.println(findCheapestPrice(3, flights,0, 2, 1));
    }
}
