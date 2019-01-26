package tag.arraystring;

/**
 *  Say you have an array for which the ith element is the price of a given stock on day i.

	Design an algorithm to find the maximum profit. You may complete at most two transactions.
	
	Note:
	You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 * @author BangChuan Liu 
 * @date   2015
 * @Contact liubangchuan1100@gmail.com
 */
public class BestTimetoBuyandSellStockIII {
	public int maxProfit(int[] prices) {
		
		if (prices == null || prices.length == 0) {
			return 0;
		}
		
		int[] left = new int[prices.length];
		int[] right = new int[prices.length];
		
		left[0] = 0;
		int min = prices[0];
		
		for (int i = 1; i < prices.length; i++) {
			min = Math.min(min, prices[i]);
			left[i] = Math.max(prices[i] - min,left[i-1]);
		}
		
		right[prices.length - 1] = 0;
		int max = prices[prices.length - 1];
		
		for (int i = prices.length - 2; i >= 0; i--) {
			max = Math.max(max, prices[i]);
			right[i] = Math.max(max-prices[i], right[i+1]);
		}
		
		int maxProfit = Integer.MIN_VALUE;
		for (int i = 0; i < prices.length; i++) {
			maxProfit = Math.max(left[i] + right[i], maxProfit);
		}
		return maxProfit;
	}
	public static void main(String[] args){
		BestTimetoBuyandSellStockIII instance = new BestTimetoBuyandSellStockIII();
		int[] a1 = {1,5,4,7,8}; //8
		int[] a2 = {2,2,2,2}; //0
		int[] a3 = {1,2,3,4,7}; //6
		System.out.println(instance.maxProfit(a1));
		System.out.println(instance.maxProfit(a2));
		System.out.println(instance.maxProfit(a3));
	}
}
