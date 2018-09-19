class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length<2) return 0;
        
        int buy = prices[0];
        int maxProfit = 0;
        for (int i = 0; i<prices.length; i++) {
            if (prices[i]<buy) {
                buy = prices[i];
            }
            int profit = prices[i] - buy;
            if (profit>maxProfit) {
                maxProfit = profit; 
            }
        }
        return maxProfit; 
    }
}