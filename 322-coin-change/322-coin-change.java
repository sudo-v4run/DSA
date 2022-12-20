class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        
        
        // Memoization ... Top-Down...
        
        int dp[][] = new int[n][amount+1];
        
        for(int row[] : dp){
            Arrays.fill(row,-1);
        }
        
        int res = f(0,amount,coins,dp);
        
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