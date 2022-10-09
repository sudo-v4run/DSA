class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        
        int profit = 0;
        for(int i = 1 ; i < n ; i++){
            if(prices[i]>prices[i-1]){
                profit+=prices[i]-prices[i-1];
            }
        }
        
        return profit;
        
        
        
        
        
        
        // Tabulation (Buttom - Up )....Space Optimized...
        
//         int cur[] = new int[2];
//         int next[] = new int[2];
        
//         next[0] = 0;
//         next[1] = 0;
        
//         for(int index = n-1 ; index>=0 ; index--){
//             for(int  canBuy = 0 ; canBuy <= 1 ; canBuy++){
//                 int profit = 0;
//                 if(canBuy==1){
//                     profit = Math.max( next[0]-prices[index],
//                                             next[1] - 0 );
//                 }else{ // selling.. sell or notSell
//                     profit = Math.max( next[1]+prices[index],
//                                             next[0] + 0 );
//                 }

//                 cur[canBuy] = profit;
//             }
//             next = cur.clone();
//         }
        
//         return next[1];
        
        
        
        
        // Tabulation (Buttom - Up )....
        
//         int dp[][] = new int[n+1][2];
        
//         dp[n][0] = 0;
//         dp[n][1] = 0;
        
//         for(int index = n-1 ; index>=0 ; index--){
//             for(int  canBuy = 0 ; canBuy <= 1 ; canBuy++){
//                 int profit = 0;
//                 if(canBuy==1){
//                     profit = Math.max( dp[index+1][0]-prices[index],
//                                             dp[index+1][1] - 0 );
//                 }else{ // selling.. sell or notSell
//                     profit = Math.max( dp[index+1][1]+prices[index],
//                                             dp[index+1][0] + 0 );
//                 }

//                 dp[index][canBuy] = profit;
//             }
//         }
        
//         return dp[0][1];
            
        
        
        
            
        
        // Memoization ... (Top - Down)...
        
//         
        
//         int dp[][] = new int[n][2];
//         for(int[] row: dp){
//             Arrays.fill(row,-1);
//         }
        
//         return maxP(0,1,prices,dp);
    }
    public static int maxP(int index , int canBuy , int prices[] ,int dp[][]){
        if(index==prices.length){
            return 0;
        }
        
        if(dp[index][canBuy] != -1 )
            return dp[index][canBuy];
        
        int profit = 0;
        if(canBuy==1){
            profit = Math.max(maxP(index+1,0,prices,dp)-prices[index] , 
                                    maxP(index+1,1,prices,dp) - 0 );
        }else{ // selling.. sell or notSell
            profit = Math.max(maxP(index+1,1,prices,dp)+prices[index] ,
                                    maxP(index+1,0,prices,dp) + 0 );
        }
        
        return dp[index][canBuy] = profit;
        
    }
}