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
        
        
        // Tabulation....
        
        int dp[][] = new int[n+1][2];
        
        dp[n][0] = 0;
        dp[n][1] = 0;
        
        for(int index = n-1 ; index >= 0 ; index--){
            for(int canBuy = 1 ; canBuy>=0 ; canBuy--){
                if(canBuy==1){
                    dp[index][canBuy] = Math.max(dp[index+1][0]-prices[index],
                                                 dp[index+1][1]);
                }else{
                    dp[index][canBuy] = Math.max(dp[index+1][1]+prices[index],
                                                 dp[index+1][0]);
                }
            }
        }
        
        return dp[0][1];
        
        
        
        // Memoization....
        
//         int dp[][] = new int[n][2];
        
//         for(int[] row : dp){
//             Arrays.fill(row,-1);
//         }
        
//         return f(0,1,prices,dp);
    }
    public static int f(int index,int canBuy,int prices[],int dp[][]){
        
        if(index==prices.length)
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