class Solution {
    public int minPathSum(int[][] arr) {
        int m = arr.length;
        int n = arr[0].length;
        
        // Memoization (Top-Down) ...
        
//         int dp[][] = new int[m][n];
//         for(int[] row:dp){
//             Arrays.fill(row,-1);
//         }
//         return mpsr(m-1,n-1,arr,dp);
        
        
        
        // Tabulation (Buttom - Up) ...
        
//         int dp[][] = new int[m][n];
        
//         dp[0][0] = arr[0][0];
        
//         for(int i = 0 ; i < m ; i++){
//             for(int j = 0 ; j < n ; j++){
//                 if(i==0 && j==0)
//                     continue;
//                 int up = Integer.MAX_VALUE;
//                 int left = Integer.MAX_VALUE;
//                 if(i>0)
//                     up = arr[i][j] + dp[i-1][j];
//                 if(j>0)
//                     left = arr[i][j] + dp[i][j-1];
//                 dp[i][j] = Math.min(up,left);
//             }
//         }
        
//         return dp[m-1][n-1];
        
        
        
        
        
        // Tabulation Space Optimized O(n) ...
        
        int cur[] = new int[n];
        int prev[] = new int[n];
        
        cur[0] = arr[0][0];
        
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(i==0 && j==0)
                    continue;
                int up = Integer.MAX_VALUE;
                int left = Integer.MAX_VALUE;
                if(i>0)
                    up = arr[i][j] + prev[j];
                if(j>0)
                    left = arr[i][j] + cur[j-1];
                cur[j] = Math.min(up,left);
            }
            prev = cur.clone();
        }
        
        return prev[n-1];
        
    }
    public static int mpsr(int i , int j , int arr[][], int dp[][] ){
        
        if(i==0 && j==0)
            return arr[0][0];
        if(i<0||j<0)
            return Integer.MAX_VALUE;
        
        if(dp[i][j] != -1)
            return dp[i][j];
        
        int up = Integer.MAX_VALUE;
        int left = Integer.MAX_VALUE;
        if(i>0)
            up = arr[i][j]+mpsr(i-1,j,arr,dp);
        if(j>0)
            left = arr[i][j]+mpsr(i,j-1,arr,dp);
        
        return dp[i][j] = Math.min(up,left);
        
        
        
        
        
        
        
        // Simple Recursion
//         if(i==0 && j==0)
//             return arr[0][0];
//         if(i<0||j<0)
//             return Integer.MAX_VALUE;
//         int up = Integer.MAX_VALUE;
//         int left = Integer.MAX_VALUE;
//         if(i>0)
//             up = arr[i][j]+mpsr(i-1,j,arr);
//         if(j>0)
//             left = arr[i][j]+mpsr(i,j-1,arr);
        
//         return Math.min(up,left);
    }
}