package easy;

/*
 * NeetCode Roadmap: Sliding Window
 * Solving Technique: Sliding Window
 * 							Maintain a range rather than iterating over the elements repeatedly
 */

public class LC0121_BestTimeToBuyAndSellStock {
	
	public static void main(String[] args) {
		LC0121_BestTimeToBuyAndSellStock bs = new LC0121_BestTimeToBuyAndSellStock();
		
		int[] prices = {3, 2, 6, 5, 0, 3};
		
		System.out.println(bs.maxProfitBruteForce(prices));
	}
	
	public int maxProfitSlidingWindow(int[] prices) {
		int buy = 0;
		int sell = 1;
		int maxP = 0;
		
		while(sell < prices.length) {
			if(prices[buy] < prices[sell]) {
				int profit = prices[sell] - prices[buy];
				
				if(maxP < profit) {
					maxP = profit;
				}
			}
			else {
				buy = sell;
			}
			
			sell++;
		}
		
		return maxP;
	}
	
	public int maxProfitBruteForce(int[] prices) {
		int max = 0;
		
		for(int i = 0; i < prices.length; i++) {
			for(int j = i + 1; j < prices.length; j++) {
				if(prices[j] - prices[i] > max) {
					max = prices[j] - prices[i];
				}
			}
		}
		
		return max;
	}
	
}
