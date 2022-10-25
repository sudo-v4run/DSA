class Solution {
    public int climbStairs(int n) {
        
        //Tabulation....
        
        int dp[] = new int[n];
        
        dp[0] = 1;
        if(n>1)
            dp[1] = 2;
        
        for(int index = 2 ; index < n ; index++){
            int oneStep = dp[index-1];
            int  twoSteps = dp[index-2];

            dp[index] = oneStep+twoSteps;
        }
        
        return dp[n-1];
        
        
        
        
        // Memoization ...
        
//         int dp[] = new int[n];
//         Arrays.fill(dp,-1);
//         return clmbstrs(n-1,dp);
    }
    public static int clmbstrs(int n,int dp[]){
        
        if(n==0)
            return 1;
        if(n==1)
            return 2;
        
        if(dp[n] != -1)
            return dp[n];
        
        int oneStep = clmbstrs(n-1,dp);
        int  twoSteps = clmbstrs(n-2,dp);
        
        return dp[n] = oneStep+twoSteps;
        
        
        
        //Recursion...
        
//         if(n==0)
//             return 1;
//         if(n==1)
//             return 2;
        
//         int oneStep = clmbstrs(n-1);
//         int  twoSteps = clmbstrs(n-2);
        
//         return oneStep+twoSteps;
    }
}