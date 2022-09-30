class Solution {
    public int minPathSum(int[][] arr) {
        int m = arr.length;
        int n = arr[0].length;
        
        // Memoization (Top-Down) ...
        
        int dp[][] = new int[m][n];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        return mpsr(m-1,n-1,arr,dp);
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