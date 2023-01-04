class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        
        int l = matrix[0][0];
        int h = matrix[n-1][n-1];
        
        while(l<=h){
            int m = l+(h-l)/2;
            
            int cnt = 0;
            
            for(int i = 0 ; i < n ; i++){
                int low = 0;
                int hi = n-1;
                
                while(low<=hi){
                    int mid = low+(hi-low)/2;
                    
                    if(matrix[i][mid]<=m){
                        low = mid+1;
                    }else{
                        hi = mid-1;
                    }
                }
                
                cnt+=low;
            }
            
            System.out.println(h);
            
            if(cnt<=k-1){
                l = m+1;
            }else{
                h = m-1;
            }
            
        }
        
        return l;
    }
}