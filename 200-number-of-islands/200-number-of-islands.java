class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        int vis[][] = new int[m][n];
        
        int cnt = 0;
        
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(grid[i][j] == '1' && vis[i][j] != 1){
                    dfs(grid,i,j,vis);
                    cnt++;
                }
            }
        }
        
        return cnt;
    }
    public static void dfs(char grid[][],int row,int col,int vis[][]){
        
        if(row<0 || row>= grid.length || col<0 || col>= grid[0].length 
                 || vis[row][col] == 1 || grid[row][col]=='0'){
            
            return;
        }
        
        vis[row][col] = 1;
        
        dfs(grid,row,col-1,vis);
        dfs(grid,row,col+1,vis);
        dfs(grid,row-1,col,vis);
        dfs(grid,row+1,col,vis);
        
    }
}