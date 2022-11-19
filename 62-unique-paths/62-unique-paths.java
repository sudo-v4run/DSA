class Solution {
    public int uniquePaths(int m, int n) {
        
        // Tabulation....Space Optimized....
        
        int prev[] = new int[n];
        int cur[] = new int[n];
        
        for(int j = 0 ; j < n ; j++){
            prev[j] = 1;
        }
        
        cur[0] = 1;
        
        for(int i = 1; i < m ; i++){
            for(int j = 1; j < n ; j++){
                
                int left = cur[j-1];
                int up = prev[j];

                cur[j] = left+up;
            }
            prev = cur.clone();
        }
        
        return prev[n-1];
        
        
        
        
        
        // Tabulation....
        
//         int dp[][] = new int[m][n];
        
//         for(int i = 0 ; i < m ; i++){
//             dp[i][0] = 1;
//         }
//         for(int j = 0 ; j < n ; j++){
//             dp[0][j] = 1;
//         }
        
//         for(int i = 1; i < m ; i++){
//             for(int j = 1; j < n ; j++){
                
//                 int left = dp[i][j-1];
//                 int up = dp[i-1][j];

//                 dp[i][j] = left+up;
//             }
//         }
        
//         return dp[m-1][n-1];
        
        
        
        
        // Memoization....
        
//         int dp[][] = new int[m][n];
//         for(int[] row:dp){
//             Arrays.fill(row,-1);
//         }
        
//         return f(m-1,n-1,dp);
        
        
        
        
        // return f(m-1,n-1);
        
    }
    public static int f(int m,int n,int dp[][]){
        
        if(m<0 || n<0)
            return 0;
        
        if(m==0 && n==0)
            return 1;
        
        if(dp[m][n] != -1)
            return dp[m][n];
        
        int left = f(m,n-1,dp);
        int up = f(m-1,n,dp);
        
        return dp[m][n] = left+up;
        
        
        
//         Recursion....
        
//         if(m<0 || n<0)
//             return 0;
        
//         if(m==0 && n==0)
//             return 1;
        
//         int left = f(m,n-1);
//         int up = f(m-1,n);
        
//         return left+up;
    }
}