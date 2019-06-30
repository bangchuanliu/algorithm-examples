package company.airbnb;

public class CheapestFlightWithKStops2 {

    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        int[] dp = new int[n];

        for (int i = 0; i < dp.length; i++) {
            if (i != src) {
                dp[i] = Integer.MAX_VALUE;
            }
        }

        for (int i = 0; i < flights.length; i++) {
            if (flights[i][0] == src) {
                dp[flights[i][1]] = flights[i][2];
            }
        }

        for (int i = 1; i <= K; i++) {
            int[] temp = new int[n];
            for (int j = 0; j < n; j++) {
                int min = Integer.MAX_VALUE;
                for (int x = 0; x < flights.length; x++) {
                    if (flights[x][1] == j) {
                        if (dp[flights[x][0]] != Integer.MAX_VALUE) {
                            min = Math.min(min, dp[flights[x][0]] + flights[x][2]);
                        }
                    }
                }
                temp[j] = Math.min(dp[j], min);
            }
            dp = temp;
        }

        return dp[dst] == Integer.MAX_VALUE ? -1 : dp[dst];
    }

    public static void main(String[] args) {
//        int[][] flights = {{0, 1, 100}, {1, 2, 100}, {0, 2, 500}};
        int[][] flights = {{4, 1, 1}, {1, 2, 3}, {0, 3, 2}, {0, 4, 10}, {3, 1, 1}, {1, 4, 3}};
        System.out.println(findCheapestPrice(5, flights, 2, 1, 1));
    }
}
