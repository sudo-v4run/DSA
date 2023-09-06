class Solution {
    public int minPathSum(int[][] arr) {
        
        int m = arr.length;
        int n = arr[0].length;
        
        // Memoization (Top-Down) ...
        
        int dp[][] = new int[m][n];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        
        return f(0,0,arr,dp);
        
        
        
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
        
//         int cur[] = new int[n];
//         int prev[] = new int[n];
        
//         cur[0] = arr[0][0];
        
//         for(int i = 0 ; i < m ; i++){
//             for(int j = 0 ; j < n ; j++){
//                 if(i==0 && j==0)
//                     continue;
//                 int up = Integer.MAX_VALUE;
//                 int left = Integer.MAX_VALUE;
//                 if(i>0)
//                     up = arr[i][j] + prev[j];
//                 if(j>0)
//                     left = arr[i][j] + cur[j-1];
//                 cur[j] = Math.min(up,left);
//             }
//             prev = cur.clone();
//         }
        
//         return prev[n-1];
        
    }
    public static int f(int r , int c , int arr[][], int dp[][]){
        
        int m = arr.length;
        int n = arr[0].length;
        
        if(r < 0 || r >= m || c < 0 || c >= n){
            return (int)1e7;
        }
        
        if(r == m-1 && c == n-1){
            return arr[m-1][n-1];
        }
        
        if(dp[r][c] != -1){
            return dp[r][c];
        }
        
        int down = arr[r][c] + f(r+1,c,arr,dp);
        int right = arr[r][c] + f(r,c+1,arr,dp);
        
        return dp[r][c] = Math.min(down,right);
    }
}