class Solution {
    public void solve(char[][] board) {
        
        int m = board.length;
        int n = board[0].length;
        
        // 1. Mark Boundary Os and it's connected Os ...
        
        for(int i = 0 ; i < m ; i++){
            dfs(board,i,0);
            dfs(board,i,n-1);
        }
        for(int j = 0 ; j < n ; j++){
            dfs(board,0,j);
            dfs(board,m-1,j);
        }
        
        // 2. Mark all the Os as X ...
        
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }
        
        // 3. Mark all the Ts as O ...
        
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(board[i][j] == 'T'){
                    board[i][j] = 'O';
                }
            }
        }
        
    }
    public static void dfs(char[][] board,int r , int c){
        if(r<0||r >= board.length||c < 0||c >= board[0].length||board[r][c] != 'O'){
            return;
        }
        
        board[r][c] = 'T';
        
        dfs(board,r-1,c);
        dfs(board,r+1,c);
        dfs(board,r,c-1);
        dfs(board,r,c+1);
    }
}