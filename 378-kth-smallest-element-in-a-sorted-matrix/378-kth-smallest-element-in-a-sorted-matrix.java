class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        
        int l = matrix[0][0];
        int h = matrix[n-1][n-1];
        
        while(l<h){
            int m = l+(h-l)/2;
            
            int cnt = 0;
            
            for(int i = 0; i < n ; i++) {
                for(int j = 0 ; j < n ; j++){
                    if(matrix[i][j]<=m){
                        cnt++;
                    }
                }
            }
            
            if(cnt<k){
                l = m+1;
            }else{
                h = m;
            }
        }
        
        return l;
    }
}