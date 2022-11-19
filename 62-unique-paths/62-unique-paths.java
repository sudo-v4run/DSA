class Solution {
    public int uniquePaths(int m, int n) {
        // return f(m-1,n-1);
        
        int dp[][] = new int[m][n];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        
        return f(m-1,n-1,dp);
    }
    public static int f(int m,int n,int dp[][]){
        
        if(m<0 || n<0)
            return 0;
        
        if(m==0 && n==0)
            return 1;
        
        if(dp[m][n] != -1)
            return dp[m][n];
        
        int left = f(m,n-1,dp);
        int right = f(m-1,n,dp);
        
        return dp[m][n] = left+right;
        
        
        
//         Recursion....
        
//         if(m<0 || n<0)
//             return 0;
        
//         if(m==0 && n==0)
//             return 1;
        
//         int left = f(m,n-1);
//         int right = f(m-1,n);
        
//         return left+right;
    }
}