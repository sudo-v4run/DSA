class Solution {
    public int maxProfit(int[] prices) {
        
        int maxP = 0;
        
        int minSoFar = prices[0];
        
        for(int i = 0 ; i < prices.length ; i++){
            minSoFar = Math.min(minSoFar,prices[i]);
            
            maxP = Math.max(maxP,prices[i]-minSoFar);
        }
        
        return maxP;
        
        
        
        
//         int buy = 0;
//         int sell = 1;
        
//         int maxP = 0;
        
//         while(sell<prices.length){
//             if(prices[sell]<prices[buy]){
//                 buy = sell;
//             }else{
//                 maxP = Math.max(maxP,prices[sell]-prices[buy]);
//             }
//             sell++;
//         }
        
//         return maxP;
    }
}