class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        
//         int maxP = 0;
        
//         for(int i = 1; i < n ; i++){
//             if(prices[i]>prices[i-1]){
//                 maxP += prices[i]-prices[i-1];
//             }
//         }
        
//         return maxP;
        
        
        
        
        // Memoization....
        
        int dp[][] = new int[n][2];
        
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        
        return f(0,1,prices,dp);
    }
    public static int f(int index,int canBuy,int prices[],int dp[][]){
        
        if(index>=prices.length)
            return 0;
        
        if(dp[index][canBuy] != -1)
            return dp[index][canBuy];
        
        if(canBuy==1){
            return dp[index][canBuy] = Math.max(f(index+1,0,prices,dp)-prices[index],
                            f(index+1,1,prices,dp));
        }else{
            return dp[index][canBuy] = Math.max(f(index+1,1,prices,dp)+prices[index],
                            f(index+1,0,prices,dp));
        }
    }
}