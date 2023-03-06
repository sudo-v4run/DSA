class Solution {
    
    static class Pair{
        int r;
        int c;
        
        Pair(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
    
    public int numEnclaves(int[][] board) {
        
        // Very Similar to Surrouned regions...
        // Boundary 1 can't account to the answer and all the 1's connected to boundary
        // 1s also can't account to the answer..Thus, Apply BFS or DFS on boundary
        // 1s and count the remaining unvisited 1s i.e. Answer...
        
        
        int m = board.length;
        int n = board[0].length;
        
        int vis[][] = new int[m][n];
        
        for(int i = 0 ; i < m ; i++){
            if(board[i][0] == 1 && vis[i][0] != 1){
                dfs(board, new Pair(i,0), vis);
            }
            if(board[i][n-1] == 1 && vis[i][n-1] != 1){
                dfs(board, new Pair(i,n-1), vis);
            }
        }
        
        for(int j = 0 ; j < n ; j++){
            if(board[0][j] == 1 && vis[0][j] != 1){
                dfs(board, new Pair(0,j), vis);
            }
            if(board[m-1][j] == 1 && vis[m-1][j] != 1){
                dfs(board, new Pair(m-1,j), vis);
            }
        }
        
        int cnt = 0;
        
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(board[i][j] == 1 && vis[i][j] == 0){
                    cnt++;
                }
            }
        }
        
        return cnt;
    }
    public static void dfs(int[][] board, Pair p, int vis[][]){
        
        int row = p.r;
        int col = p.c;
        
        if( row < 0 || row >= board.length || col < 0 || col >= board[0].length ||
            board[row][col] == 0 || vis[row][col] == 1 ){
            
            return;
        }
        
        vis[row][col] = 1;
        
        dfs(board, new Pair(row-1,col), vis);
        dfs(board, new Pair(row,col-1), vis);
        dfs(board, new Pair(row+1,col), vis);
        dfs(board, new Pair(row,col+1), vis);
    }
}