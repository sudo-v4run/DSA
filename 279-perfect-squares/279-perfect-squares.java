class Solution {
    public int numSquares(int n) {
        
        // Tabulation...
        
        int dp[] = new int[n+1];
        
        Arrays.fill(dp,(int)1e9);
        
        dp[0] = 0;
        
        for(int i = 1 ; i <= n ; i++){
            for(int s = 1 ; s*s <= n ; s++){
                if(i-s*s>=0){
                    dp[i] = Math.min(dp[i],1+dp[i-(s*s)]);
                }
            }
        }
        
        return dp[n];
        
        
        // Memoization .. Top Down.. MLE...
        
        // int dp[][] = new int[n+1][n+1];
        // for(int row[] : dp){
        //     Arrays.fill(row,-1);
        // }
        // return f(1,n,dp)==(int)1e9?-1:f(1,n,dp);
        
    }
    public static int f(int index,int amount,int dp[][]){
        
        
        // MLE....
        
        if(amount==0){
            return 0;
        }
        if(index*index>amount || amount<0){
            return (int)1e9;
        }
        
        if(dp[index][amount] != -1)
            return dp[index][amount];
        
        int min = (int)1e9;
        
        int takeThis = 1+f(index,amount-(index*index),dp);
        int notTake = f(index+1,amount,dp);
        
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