class Solution {
    public void solveSudoku(char[][] board) {
        
        int n = board.length;
        
        f(board);
    }
    public static boolean f(char[][] board){
        
        int n = board.length;
        
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                if(board[i][j] == '.'){
                    for(char ch = '1' ; ch <= '9' ; ch++){
                        if(isPossible(i,j,ch,board)){
                            board[i][j] = ch;
                            if(f(board)){
                                return true;
                            }
                            board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        
        return true;
    }
    public static boolean isPossible(int r, int c, char ch, char[][] board){
        
        int n = board.length;
        
        for(int i = 0 ; i < n ; i++){
            if(board[i][c] == ch){
                return false;
            }
        }
        
        for(int i = 0 ; i < n ; i++){
            if(board[r][i] == ch){
                return false;
            }
        }
        
        int boxRowStart = (r/3)*3;
        int boxColStart = (c/3)*3;
        
        for(int i = boxRowStart ; i < boxRowStart+3 ; i++){
            for(int j = boxColStart ; j < boxColStart+3 ; j++){
                if(board[i][j] == ch){
                    return false;
                }
            }
        }
        
        
        return true;
    }
}