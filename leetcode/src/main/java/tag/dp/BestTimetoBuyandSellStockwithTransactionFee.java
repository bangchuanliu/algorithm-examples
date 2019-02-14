package tag.dp;

public class BestTimetoBuyandSellStockwithTransactionFee {

    public int maxProfit(int[] prices, int fee) {
        int min = prices[0];
        int sum = 0;
        int max = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i-1] + fee) {
                sum += prices[i] - prices[i-1] - fee;
                int temp = prices[i] - min - fee;
                max = Math.max(max, Math.max(sum, temp));
            }
        }

        return max;
    }

    public static void main(String[] args) {
        BestTimetoBuyandSellStockwithTransactionFee instance = new BestTimetoBuyandSellStockwithTransactionFee();
        int[] prices = {1, 3, 2, 8, 4, 9};
        System.out.println(instance.maxProfit(prices,2));
    }
}
