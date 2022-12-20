class Solution {
    public int coinChange(int[] coins, int amnt) {
        int n = coins.length;
        
        // Tabulation .... SC- O(N)...
        
        int dp[] = new int[amnt+1];
        
        Arrays.fill(dp,(int)1e9);
        
        dp[0] = 0;
        
        for(int index = 0 ; index < n ; index++){
            for(int amount = 1 ; amount <= amnt ; amount++){
                if(coins[index]>amount)
                    continue;
                
                dp[amount] = Math.min(dp[amount],1+dp[amount-coins[index]]);
            }
        }
        
        int res = dp[amnt];
        
        
        // Tabulation.... Buttom-Up.... SpaceOptimized
        
//         int cur[] = new int[amnt+1];
//         int next[] = new int[amnt+1];
        
//         for(int amount = 1 ; amount <= amnt ; amount++){
//             next[amount] = (int)1e9;
//         }
        
//         for(int index = n-1 ; index>=0 ; index--){
//             for(int amount = 1 ; amount <= amnt ; amount++){
                
//                 int take = (int)1e9;
                
//                 if(amount-coins[index]>=0)
//                     take = 1+cur[amount-coins[index]];
                
//                 int notTake = next[amount];

//                 cur[amount] = Math.min(take,notTake);
                
//             }
//             next = cur.clone();
//         }
        
//         int res = next[amnt];
        
        
        
        
        
        // Tabulation.... Buttom-Up....
        
//         int dp[][] = new int[n+1][amnt+1];
        
//         for(int amount = 1 ; amount <= amnt ; amount++){
//             dp[n][amount] = (int)1e9;
//         }
        
//         for(int index = n-1 ; index>=0 ; index--){
//             for(int amount = 1 ; amount <= amnt ; amount++){
                
//                 int take = (int)1e9;
                
//                 if(amount-coins[index]>=0)
//                     take = 1+dp[index][amount-coins[index]];
                
//                 int notTake = dp[index+1][amount];

//                 dp[index][amount] = Math.min(take,notTake);
                
//             }
//         }
        
//         int res = dp[0][amnt];
        
        
        
        
        // Memoization ... Top-Down...
        
//         int dp[][] = new int[n][amnt+1];
        
//         for(int row[] : dp){
//             Arrays.fill(row,-1);
//         }
        
//         int res = f(0,amnt,coins,dp);
        
        
        
        
        return res==(int)1e9?-1:res;
        
    }
    public static int f(int index,int amount,int coins[],int dp[][]){
        
        if(amount==0){
            return 0;
        }
        
        if(index>=coins.length || amount < 0){
            return (int)1e9;
        }
        
        if(dp[index][amount] != -1)
            return dp[index][amount];
        
        int take = 1+f(index,amount-coins[index],coins,dp);
        int notTake = f(index+1,amount,coins,dp);
        
        return dp[index][amount] = Math.min(take,notTake);
        
        
        
        
//         if(amount==0){
//             return 0;
//         }
        
//         if(index>=coins.length || amount < 0){
//             return (int)1e9;
//         }
        
//         int take = 1+f(index,amount-coins[index],coins);
//         int notTake = f(index+1,amount,coins);
        
//         return Math.min(take,notTake);
    }
}