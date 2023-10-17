class Solution {
    public int[][] constructProductMatrix(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        
        int mod = 12345;
        
        int pre[][] = new int[m][n];
        int suff[][] = new int[m][n];
        
        long p = 1;
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                pre[i][j] = (int)p;
                p = (p*grid[i][j])%mod;
            }
        }
        
        p = 1;
        for(int i = m-1 ; i >=0 ; i--){
            for(int j = n-1 ; j >= 0 ; j--){
                suff[i][j] = (int)p;
                p = (p*grid[i][j])%mod;
            }
        }
        
        int res[][] = new int[m][n];
        
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                long temp = pre[i][j]*suff[i][j];
                temp = temp%mod;
                
                res[i][j] = (int)temp;
            }
        }
        
        return res;
    }
}