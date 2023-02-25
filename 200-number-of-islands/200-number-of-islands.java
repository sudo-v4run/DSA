class Solution {
    public int numIslands(char[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        
        int cnt = 0;
        
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(grid[i][j] == '1'){
                    dfs(grid,i,j);
                    cnt++;
                }
            }
        }
        
        return cnt;
    }
    public static void dfs(char grid[][],int row,int col){
        
        if(row<0 || row>= grid.length || col<0 || col>= grid[0].length 
                 || grid[row][col]=='0'){
            
            return;
        }
        
        grid[row][col] = '0';       // or we can use a vis matrix..
        
        dfs(grid,row,col-1);
        dfs(grid,row,col+1);
        dfs(grid,row-1,col);
        dfs(grid,row+1,col);
        
    }
}