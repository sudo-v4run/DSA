class Solution {
    public int maximalSquare(char[][] matrix) {
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        int len = 0;
        
        int dp[][] = new int[m][n];
        
        for(int i = 0 ; i < n ; i++){
            dp[0][i] = Integer.parseInt(String.valueOf(matrix[0][i]));
        }
        
        for(int i = 0 ; i < m ; i++){
            dp[i][0] = Integer.parseInt(String.valueOf(matrix[i][0]));
        }
        
        for(int i = 1 ; i < m ; i++){
            for(int j = 1 ; j < n ; j++){
                if(matrix[i][j] == '0'){
                    dp[i][j] = 0;
                }else{
                    dp[i][j] = 1 + Math.min(dp[i-1][j-1],
                                   Math.min(dp[i-1][j],dp[i][j-1]));
                }
            }
        }
        
        for(int row[] : dp){
            for(int k : row){
                len = Math.max(len,k);
            }
        }
        
        return len*len;
    }
}