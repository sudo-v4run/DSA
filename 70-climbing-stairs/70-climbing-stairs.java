class Solution {
    public int climbStairs(int n) {
        
        // Memoization ...
        
        int dp[] = new int[n];
        Arrays.fill(dp,-1);
        return clmbstrs(n-1,dp);
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