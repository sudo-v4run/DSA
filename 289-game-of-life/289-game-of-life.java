class Solution {
    
    public void gameOfLife(int[][] board){
        
//         original   |   new   | change
//         _____________________________
            
//             0      |    0    |    2
//             0      |    1    |    3
//             1      |    0    |    4
//             1      |    1    |    5
        
        
        
        int m = board.length;
        int n = board[0].length;
        
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                int nieLivesCells = cntNeiLiveCells(board,i,j);
                
                if(board[i][j]==1){
                    if(nieLivesCells<2 || nieLivesCells>3){
                        board[i][j] = 4;
                    }else if(nieLivesCells == 2 || nieLivesCells == 3){
                        board[i][j] = 5;
                    }
                }else{
                    if(nieLivesCells==3){
                        board[i][j] = 3;
                    }else{
                        board[i][j] = 2;
                    }
                }
                
            }
        }
        
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                
                if(board[i][j] == 2){
                    board[i][j] = 0;
                }else if(board[i][j] == 3){
                    board[i][j] = 1;
                }else if(board[i][j] == 4){
                    board[i][j] = 0;
                }else if(board[i][j] == 5){
                    board[i][j] = 1;
                }
                
            }
        }
        
    }
    
    public static int cntNeiLiveCells(int arr[][] , int row , int col){
        int nieLivesCells = 0;
        
        for(int r = -1 ; r <= 1 ; r++){
            for(int c = -1 ; c <= 1 ; c++){
                if((r==0 && c==0) || row+r < 0 || row+r >= arr.length 
                                      || col+c < 0 || col+c >= arr[0].length){
                    continue;
                }
                if(arr[row+r][col+c]==1 || arr[row+r][col+c]==4 || arr[row+r][col+c]==5){
                    nieLivesCells++;
                }
            }
        }
        
        return nieLivesCells;
    }
        
        
//     public void gameOfLife(int[][] board) {
//         int m = board.length;
//         int n = board[0].length;
        
//         int arr[][] = new int[m][n];
        
//         for(int i = 0 ; i < m ; i++){
//             for(int j = 0 ; j < n ; j++){
//                 if(canLive(board,i,j)){
//                     arr[i][j] = 1;
//                 }else{
//                     arr[i][j] = 0;
//                 }
//             }
//         }
        
//         for(int i = 0 ; i < m ; i++){
//             for(int j = 0 ; j < n ; j++){
//                 board[i][j] = arr[i][j];
//             }
//         }
        
        
//     }
//     public static boolean canLive(int arr[][],int r,int c){
//         int cnt0 = 0;
//         int cnt1 = 0;
        
//         if(c-1>=0 && arr[r][c-1]==0){
//             cnt0++;
//         }else if(c-1>=0 && arr[r][c-1]==1){
//             cnt1++;
//         }
        
//         if(r+1 < arr.length && c-1>=0 && arr[r+1][c-1]==0){
//             cnt0++;
//         }else if(r+1 < arr.length && c-1>=0 && arr[r+1][c-1]==1){
//             cnt1++;
//         }
        
//         if(r+1 < arr.length && arr[r+1][c]==0){
//             cnt0++;
//         }else if(r+1 < arr.length && arr[r+1][c]==1){
//             cnt1++;
//         }
        
//         if(r+1 < arr.length && c+1 < arr[0].length && arr[r+1][c+1]==0){
//             cnt0++;
//         }else if(r+1 < arr.length && c+1 < arr[0].length && arr[r+1][c+1]==1){
//             cnt1++;
//         }
        
//         if(c+1 < arr[0].length && arr[r][c+1]==0){
//             cnt0++;
//         }else if(c+1 < arr[0].length && arr[r][c+1]==1){
//             cnt1++;
//         }
        
//         if(r-1>=0 && c+1 < arr[0].length && arr[r-1][c+1]==0){
//             cnt0++;
//         }else if(r-1>=0 && c+1 < arr[0].length && arr[r-1][c+1]==1){
//             cnt1++;
//         }
        
//         if(r-1>=0 && arr[r-1][c]==0){
//             cnt0++;
//         }else if(r-1>=0 && arr[r-1][c]==1){
//             cnt1++;
//         }
        
//         if(r-1>=0 && c-1>=0 && arr[r-1][c-1]==0){
//             cnt0++;
//         }else if(r-1>=0 && c-1>=0 && arr[r-1][c-1]==1){
//             cnt1++;
//         }
        
//         if(arr[r][c]==1){
//             if(cnt1<2){
//                 return false;
//             }else if(cnt1>3){
//                 return false;
//             }
//             return true;
//         }else{
//             if(cnt1==3){
//                 return true;
//             }
//             return false;
//         }
        
//     }
    
}