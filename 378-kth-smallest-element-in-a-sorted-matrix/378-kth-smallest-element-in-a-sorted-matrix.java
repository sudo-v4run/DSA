class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        
        int l = matrix[0][0];
        int h = matrix[n-1][n-1]+1;
        
        while(l<h){
            int m = l+(h-l)/2;
            
            int cnt = 0;
            int j = matrix[0].length - 1;
            
            for(int i = 0; i < matrix.length; i++) {
                
                while(j >= 0 && matrix[i][j] > m)
                    j--;
                
                cnt += (j + 1);
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