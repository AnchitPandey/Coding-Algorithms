class Solution {
    
    public int maxProfit(int[] prices) {
        int profit =0;
        int n  = prices.length;
        for (int i =0; i< n-1;i+=1)
        {
            if (prices[i+1] > prices[i])
                profit  += prices[i+1] - prices[i];
        }
        return profit;
    }
}
