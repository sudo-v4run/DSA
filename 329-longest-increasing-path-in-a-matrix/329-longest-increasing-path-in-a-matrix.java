class Solution {
    
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        int dp[][] = new int[m][n];
        
        for(int row[] : dp){
            Arrays.fill(row,1);
        }
        
        int lip = 1;
        
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                lip = Math.max(lip,dfs(matrix,i,j,-1,dp));
            }
        }
        
        return lip;
    }
    public static int dfs(int arr[][], int r, int c, 
                           int last, int dp[][]){
        
        if(r<0 || r>=arr.length || c<0 || c>=arr[0].length || arr[r][c]<=last){
            
            return Integer.MIN_VALUE;
        }
        
        if(dp[r][c] != 1){
            return dp[r][c];
        }
        
        int max = 1;
        
        int up = dfs(arr,r-1,c,arr[r][c],dp);
        max = Math.max(up+1,max);
        
        int left = dfs(arr,r,c-1,arr[r][c],dp);
        max = Math.max(left+1,max);
        
        int down = dfs(arr,r+1,c,arr[r][c],dp);
        max = Math.max(down+1,max);
        
        int right = dfs(arr,r,c+1,arr[r][c],dp);
        max = Math.max(right+1,max);
        
        return dp[r][c] = max;
    }
}