class Solution {
    public int uniquePathsWithObstacles(int[][] arr) {
        
        int m = arr.length;
        int n = arr[0].length;
        
        
        // Momoization (Top - Down) ...
        
        // int dp[][] = new int[m][n];
        // for(int[] row : dp){
        //     Arrays.fill(row,-1);
        // }
        // return up2(m-1,n-1,arr,dp);
        
        
        // Tabulation (Buttom - Up) ...
        
        int dp[][] = new int[m][n];
        
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(arr[i][j]==1)
                    dp[i][j]=0;
                else if(i==0 && j==0)
                    dp[i][j] = 1;
                else{
                    int up = 0;
                    int left = 0;
                    if(i>0)
                        up+=dp[i-1][j];
                    if(j>0)
                        left+=dp[i][j-1];
                    dp[i][j] = up+left;
                }
            }
        }
        
        return dp[m-1][n-1];
        
    }
    public static int up2(int i , int j , int arr[][],int dp[][]){
        
        if(i>=0 && j>=0 && arr[i][j]==1)
            return 0;
        if(i==0&&j==0){
            return 1;
        }
        if(i<0||j<0)
            return 0;
        
        if(dp[i][j] != -1)
            return dp[i][j];
        
        int up = up2(i-1,j,arr,dp);
        int left = up2(i,j-1,arr,dp);
        
        return dp[i][j] = up+left;
        
        
        
        
        
        
        
        
        // Only Recursion ...
        
//         if(i>=0 && j>=0 && arr[i][j]==1)
//             return 0;
//         if(i==0&&j==0){
//             return 1;
//         }
//         if(i<0||j<0)
//             return 0;
        
        
        
//         int up = up2(i-1,j,arr);
//         int left = up2(i,j-1,arr);
        
//         return up+left;
    }
}