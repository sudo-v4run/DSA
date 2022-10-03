class Solution {
    public int change(int target, int[] coins) {

        int n = coins.length;
        
        // Memoization (Top-Down) ...
        int dp[][] = new int[n][target+1];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        return coinc2(n-1,target,coins,dp);
    }
    
    
    public static int coinc2(int index , int target,int coins[],int dp[][]){
        if(index==0){
            if(target%coins[index]==0)
                return 1;
            return 0;
        }
        
        if(dp[index][target] != -1)
            return dp[index][target];
        
        int pick = 0;
        if(coins[index]<=target){
            pick = coinc2(index,target-coins[index],coins,dp);
        }
        int notPick = coinc2(index-1,target,coins,dp);
        
        return dp[index][target] = pick+notPick;
        
        
        
        // Recursion ....
        
//         if(index==0){
//             if(target%coins[index]==0)
//                 return 1;
//             return 0;
//         }
        
//         int pick = 0;
//         if(coins[index]<=target){
//             pick = coinc2(index,target-coins[index],coins);
//         }
//         int notPick = coinc2(index-1,target,coins);
        
//         return pick+notPick;
    }
}