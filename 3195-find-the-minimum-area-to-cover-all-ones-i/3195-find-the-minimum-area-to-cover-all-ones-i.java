class Solution {
    public int minimumArea(int[][] arr) {
        
        int m = arr.length;
        int n = arr[0].length;
        
        int top = 0;
        boolean got = false;
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(arr[i][j] == 1){
                    top = i;
                    got = true;
                    break;
                }
            }
            if(got){
                break;
            }
        }
        
        int right = n-1;
        got = false;
        for(int j = n-1 ; j >= 0 ; j--){
            for(int i = 0 ; i < m ; i++){
                if(arr[i][j] == 1){
                    right = j;
                    got = true;
                    break;
                }
            }
            if(got){
                break;
            }
        }
        
        int down = m-1;
        got = false;
        for(int i = m-1 ; i >= 0 ; i--){
            for(int j = 0 ; j < n ; j++){
                if(arr[i][j] == 1){
                    down = i;
                    got = true;
                    break;
                }
            }
            if(got){
                break;
            }
        }
        
        int left = 0;
        got = false;
        for(int j = 0 ; j < n ; j++){
            for(int i = 0 ; i < m ; i++){
                if(arr[i][j] == 1){
                    left = j;
                    got = true;
                    break;
                }
            }
            if(got){
                break;
            }
        }
        
        
        int ht = down-top+1;
        int width = right-left+1;
        
        return ht*width;
    }
}