class Solution {
    public int countSubmatrices(int[][] arr, int k) {
        
        int m = arr.length;
        int n = arr[0].length;
        
        int cnt = 0;
        
        int prefix[][] = new int[m][n];
        
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                
                int cur = arr[i][j];
                
                int up = 0;
                if(i-1 >= 0){
                    up = prefix[i-1][j];
                }
                
                int left = 0;
                if(j-1 >= 0){
                    left = prefix[i][j-1];
                }
                
                int diagonal = 0;
                if(i-1 >= 0 && j-1 >= 0){
                    diagonal = prefix[i-1][j-1];
                }
                
                prefix[i][j] = up+left+cur-diagonal;
                
                if(prefix[i][j] <= k){
                    cnt++;
                }
            }
        }
        
        return cnt;
    }
}