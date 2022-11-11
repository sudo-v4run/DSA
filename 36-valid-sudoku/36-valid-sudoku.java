class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        for(int i = 0 ; i <= 8 ; i++){
            for(int j = 0 ; j <= 8 ; j++){
                if(board[i][j] != '.'){
                    if(!isPossible(board,i,j))
                        return false;
                }
            }
        }
        
        return true;
    }
    public static boolean isPossible(char arr[][],int r, int c){
        char ele = arr[r][c];
        
        for(int i = 0 ; i <= 8 ;i++){
            if(i!=c && arr[r][i] == ele)
                return false;
        }
        for(int i = 0 ; i <= 8 ; i++){
            if(i!=r && arr[i][c] == ele)
                return false;
        }
        
        int brs = r/3;
        int bcs = c/3;
        
        brs = brs*3;
        bcs = bcs*3;
        
        for(int i = brs; i<brs+3;i++){
            for(int j = bcs ; j < bcs+3 ; j++){
                if(i!=r && j!= c && arr[i][j] == ele)
                    return false;
            }
        }
        
        return true;
    }
}