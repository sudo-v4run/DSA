class Solution {
    public int maxScore(List<List<Integer>> grid) {
        
        int m = grid.size();
        int n = grid.get(0).size();
        
        int arr[][] = new int[m][n];
        
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                arr[i][j] = grid.get(i).get(j);
            }
        }
        
        int dp[][] = new int[m][n];
        for(int row[] : dp){
            Arrays.fill(row,-1);
        }
        
        int ans = Integer.MIN_VALUE;
        
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                int cur = f(i,j,arr,dp);
                ans = Math.max(ans,cur);
            }
        }
        
        return ans;
    }
    public int f(int r, int c, int arr[][], int dp[][]){
        
        int m = arr.length;
        int n = arr[0].length;
        
        if(r == m-1 && c == n-1){
            return -(int)1e7;
        }
        
        if(dp[r][c] != -1){
            return dp[r][c];
        }
        
        int ans = Integer.MIN_VALUE;
        
        // down...
            
        for(int i = r+1 ; i < m ; i++){
            int stopAti = arr[i][c] - arr[r][c];
            int notStop = (arr[i][c] - arr[r][c]) + f(i,c,arr,dp);
            
            ans = Math.max(ans,Math.max(stopAti,notStop));
        }
        
        // right...
        
        for(int i = c+1 ; i < n ; i++){
            int stopAti = arr[r][i] - arr[r][c];
            int notStop = (arr[r][i] - arr[r][c]) + f(r,i,arr,dp);
            
            ans = Math.max(ans,Math.max(stopAti,notStop));
        }
        
        return dp[r][c] = ans;
    }
}