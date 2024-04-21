class Solution {
    public int minimumOperations(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        
        int dp[][] = new int[n][11];
        
        for(int row[] : dp){
            Arrays.fill(row,-1);
        }
        
        return f(0,-1,grid,dp);
    }
    public int f(int index, int prev, int arr[][], int dp[][]){
        
        int m = arr.length;
        int n = arr[0].length;
        
        if(index >= n){
            return 0;
        }
        
        if(dp[index][prev+1] != -1){
            return dp[index][prev+1];
        }
        
        int ans = Integer.MAX_VALUE;
        
        for(int i = 0 ; i <= 9 ; i++){
            
            if(i == prev){
                continue;
            }
            
            int ops = 0;
            
            for(int r = 0 ; r < m ; r++){
                if(arr[r][index] != i){
                    ops++;
                }
            }
            
            int cur = ops + f(index+1,i,arr,dp);
            
            ans = Math.min(ans,cur);
        }
        
        return dp[index][prev+1] = ans;
    }
}