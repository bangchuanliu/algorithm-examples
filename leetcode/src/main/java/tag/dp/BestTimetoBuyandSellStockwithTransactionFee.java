package tag.dp;

public class BestTimetoBuyandSellStockwithTransactionFee {

    public int maxProfit(int[] prices, int fee) {
        int[] dp = new int[prices.length];
        dp[0] = 0;
        for (int i = 1; i< prices.length; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (prices[j] + fee < prices[i])
                    max = Math.max(max, prices[i] - prices[j] - fee + dp[j]);
            }
            max = Math.max(max, dp[i-1]);
            dp[i] = max;
        }

        return dp[dp.length-1];
    }

    public static void main(String[] args) {
        BestTimetoBuyandSellStockwithTransactionFee instance = new BestTimetoBuyandSellStockwithTransactionFee();
        int[] prices = {1, 3, 2, 8, 4, 9};
        System.out.println(instance.maxProfit(prices,2));
    }
}
