class Solution {
    
    static class Pair{
        int r;
        int c;
        
        Pair(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
    public void solve(char[][] board) {
        
        int m = board.length;
        int n = board[0].length;
        
        int vis[][] = new int[m][n];
        
        for(int i = 0 ; i < m ; i++){
            if(board[i][0] == 'O' && vis[i][0] != 1){
                dfs(board, new Pair(i,0), vis);
            }
            if(board[i][n-1] == 'O' && vis[i][n-1] != 1){
                dfs(board, new Pair(i,n-1), vis);
            }
        }
        
        for(int j = 0 ; j < n ; j++){
            if(board[0][j] == 'O' && vis[0][j] != 1){
                dfs(board, new Pair(0,j), vis);
            }
            if(board[m-1][j] == 'O' && vis[m-1][j] != 1){
                dfs(board, new Pair(m-1,j), vis);
            }
        }
        
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(vis[i][j] == 1){
                    board[i][j] = 'O';
                }else{
                    board[i][j] = 'X';
                }
            }
        }
        
    }
    public static void dfs(char[][] board, Pair p, int vis[][]){
        
        int row = p.r;
        int col = p.c;
        
        if( row < 0 || row >= board.length || col < 0 || col >= board[0].length ||
            board[row][col] == 'X' || vis[row][col] == 1 ){
            
            return;
        }
        
        vis[row][col] = 1;
        
        dfs(board, new Pair(row-1,col), vis);
        dfs(board, new Pair(row,col-1), vis);
        dfs(board, new Pair(row+1,col), vis);
        dfs(board, new Pair(row,col+1), vis);
    }
}