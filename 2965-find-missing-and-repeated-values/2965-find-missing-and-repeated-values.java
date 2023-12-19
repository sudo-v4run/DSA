class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        
        int n = grid.length;
        
        n = n*n;
        
        int arr[] = new int[n];
        int kk = 0;
        for(int i = 0 ; i < grid.length ; i++){
            for(int j = 0 ; j < grid[0].length ; j++){
                arr[kk++] = grid[i][j];
            }
        }
        int xxory = 0;
        
        for(int val : arr){
            xxory = xxory ^ val;
        }
        
        for(int i = 1 ; i <= n ; i++){
            xxory = xxory ^ i;
        }
        
        // separating x and y...
        
        int rmsb = xxory & -xxory;  // right most set bit mask
        
        int x = 0, y = 0;
        
        for(int val : arr){
            if((val & rmsb) == 0){
                x = x ^ val;
            }else{
                y = y ^ val;
            }
        }
        
        for(int i = 1 ; i <= n ; i++){
            if((i & rmsb) == 0){
                x = x ^ i;
            }else{
                y = y ^ i;
            }
        }
        
        for(int val : arr){
            if(x == val){
                return new int[]{x,y};
            }
        }
        return new int[]{y,x};
    }
}