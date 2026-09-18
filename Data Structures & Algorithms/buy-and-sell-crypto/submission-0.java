class Solution {
    public int maxProfit(int[] prices) {
        int start = 0;
        int maxProfit = 0;
      for(int end = 1;end < prices.length;end++){
if(prices[start] < prices[end]){
  int profit = prices[end] - prices[start];
    maxProfit = Math.max(maxProfit, profit);
}else{
start = end;
}
        }
        return maxProfit;
    }
}
