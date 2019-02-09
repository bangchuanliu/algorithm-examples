package tag.array;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 * 
 * @author BangChuan Liu 
 * @date   2015
 * 
 * @version 2.0
 * @since Feb,5, 2019
 */
public class BestTimetoBuyandSellStock {

	public int maxProfit(int[] prices) {
		if (prices == null || prices.length == 0) {
			return 0;
		}

		int minPrice = prices[0];
		int profit = 0;
		for (int i = 1; i < prices.length; i++) {
			profit = Math.max(profit, prices[i] - minPrice);
			minPrice = Math.min(minPrice, prices[i]);
		}

		return profit;
	}
	
	public static void main(String[] args){
		BestTimetoBuyandSellStock instance = new BestTimetoBuyandSellStock();
		int[] a1 = {2,7,6,0}; //5
		int[] a2 = {2,2,2,2}; //0
		int[] a3 = {1,2,3,4}; //3

		System.out.println(instance.maxProfit(a1));
		System.out.println(instance.maxProfit(a2));
		System.out.println(instance.maxProfit(a2));
	}
}
