class neighborSum {

    int arr[][];
    public neighborSum(int[][] grid) {
        this.arr = grid;
    }
    
    public int adjacentSum(int value) {
        int s = 0;
        
        int n = arr.length;
        
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                if(arr[i][j] == value){
                    if(j-1 >= 0){
                        s += arr[i][j-1];
                    }
                    if(i+1 < n){
                        s += arr[i+1][j];
                    }
                    if(j+1 < n){
                        s += arr[i][j+1];
                    }
                    if(i-1 >= 0){
                        s += arr[i-1][j];
                    }
                    return s;
                }
            }
        }
        
        return s;
    }
    
    public int diagonalSum(int value) {
        int s = 0;
        
        int n = arr.length;
        
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                if(arr[i][j] == value){
                    if(j-1 >= 0 && i-1 >= 0){
                        s += arr[i-1][j-1];
                    }
                    if(i+1 < n && j-1 >= 0){
                        s += arr[i+1][j-1];
                    }
                    if(j+1 < n && i+1 < n){
                        s += arr[i+1][j+1];
                    }
                    if(i-1 >= 0 && j+1 < n){
                        s += arr[i-1][j+1];
                    }
                    return s;
                }
            }
        }
        
        return s;
    }
}

/**
 * Your neighborSum object will be instantiated and called as such:
 * neighborSum obj = new neighborSum(grid);
 * int param_1 = obj.adjacentSum(value);
 * int param_2 = obj.diagonalSum(value);
 */