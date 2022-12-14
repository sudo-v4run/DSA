class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int dp[][] = new int[n][amount+1];
        for(int row[] : dp){
            Arrays.fill(row,-1);
        }
        return f(0,amount,coins,dp)==(int)1e9?-1:f(0,amount,coins,dp);
    }
    public static int f(int index,int amount,int coins[],int dp[][]){
        if(amount==0){
            return 0;
        }
        if(amount<0 || index>=coins.length){
            return (int)1e9;
        }
        
        if(dp[index][amount] != -1)
            return dp[index][amount];
        
        int min = (int)1e9;
        
        int takeThis = 1+f(index,amount-coins[index],coins,dp);
        int notTake = f(index+1,amount,coins,dp);
        
        min = Math.min(takeThis,notTake);
        
        return dp[index][amount] = min;
        
        
        
        
//         if(amount==0){
//             return 0;
//         }
//         if(amount<0 || index>=coins.length){
//             return (int)1e9;
//         }
        
//         int min = (int)1e9;
        
//         int takeThis = 1+f(index,amount-coins[index],coins);
//         int notTake = f(index+1,amount,coins);
        
//         min = Math.min(takeThis,notTake);
        
//         return min;
        
    }
}