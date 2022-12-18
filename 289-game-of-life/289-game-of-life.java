class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        
        int arr[][] = new int[m][n];
        
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(canLive(board,i,j)){
                    arr[i][j] = 1;
                }else{
                    arr[i][j] = 0;
                }
            }
        }
        
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                board[i][j] = arr[i][j];
            }
        }
        
        
    }
    public static boolean canLive(int arr[][],int r,int c){
        int cnt0 = 0;
        int cnt1 = 0;
        
        if(c-1>=0 && arr[r][c-1]==0){
            cnt0++;
        }else if(c-1>=0 && arr[r][c-1]==1){
            cnt1++;
        }
        
        if(r+1 < arr.length && c-1>=0 && arr[r+1][c-1]==0){
            cnt0++;
        }else if(r+1 < arr.length && c-1>=0 && arr[r+1][c-1]==1){
            cnt1++;
        }
        
        if(r+1 < arr.length && arr[r+1][c]==0){
            cnt0++;
        }else if(r+1 < arr.length && arr[r+1][c]==1){
            cnt1++;
        }
        
        if(r+1 < arr.length && c+1 < arr[0].length && arr[r+1][c+1]==0){
            cnt0++;
        }else if(r+1 < arr.length && c+1 < arr[0].length && arr[r+1][c+1]==1){
            cnt1++;
        }
        
        if(c+1 < arr[0].length && arr[r][c+1]==0){
            cnt0++;
        }else if(c+1 < arr[0].length && arr[r][c+1]==1){
            cnt1++;
        }
        
        if(r-1>=0 && c+1 < arr[0].length && arr[r-1][c+1]==0){
            cnt0++;
        }else if(r-1>=0 && c+1 < arr[0].length && arr[r-1][c+1]==1){
            cnt1++;
        }
        
        if(r-1>=0 && arr[r-1][c]==0){
            cnt0++;
        }else if(r-1>=0 && arr[r-1][c]==1){
            cnt1++;
        }
        
        if(r-1>=0 && c-1>=0 && arr[r-1][c-1]==0){
            cnt0++;
        }else if(r-1>=0 && c-1>=0 && arr[r-1][c-1]==1){
            cnt1++;
        }
        
        if(arr[r][c]==1){
            if(cnt1<2){
                return false;
            }else if(cnt1>3){
                return false;
            }
            return true;
        }else{
            if(cnt1==3){
                return true;
            }
            return false;
        }
        
    }
}