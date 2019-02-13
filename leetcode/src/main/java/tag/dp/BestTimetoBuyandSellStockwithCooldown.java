package tag.dp;

public class BestTimetoBuyandSellStockwithCooldown {
    
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int[] dp = new int[prices.length + 1];
        int min = prices[0];
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < prices.length; i++) {
            min = Math.min(prices[i], min);
            int case1 = prices[i] - min;
            int case2 = i >= 3 ? dp[i-3] + prices[i] - prices[i-1] : 0;
            dp[i] = Math.max(case1,case2);
            dp[i] = Math.max(dp[i], dp[i-1]);
            max = Math.max(max, dp[i]);
        }
        
        return max;
    }
    
    
    public static void main(String[] args) {
        int[] nums = {2,1,2,1,0,0,1};
        System.out.println(new BestTimetoBuyandSellStockwithCooldown().maxProfit(nums));
    }
}
