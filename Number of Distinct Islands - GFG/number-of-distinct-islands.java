//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] grid = new int[n][m];

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < m; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }

            Solution ob = new Solution();
            int ans = ob.countDistinctIslands(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends

class Solution {

    int countDistinctIslands(int[][] grid) {
        
        HashSet<ArrayList<String>> hs = new HashSet<>();
        
        int m = grid.length;
        int n = grid[0].length;
        
        int vis[][] = new int[m][n];
        
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(grid[i][j] == 1 && vis[i][j] != 1){
                    
                    ArrayList<String> arr = new ArrayList<>();
                    dfs(grid,i,j,i,j,arr,vis);
                    hs.add(arr);
                }
            }
        }
        
        return hs.size();
    }
    public static void dfs( int grid[][], int r, int c, int baseR, int baseC,
                            ArrayList<String> arr, int vis[][] ){
                                
        if( r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || 
            grid[r][c] == 0 || vis[r][c] == 1 ){
                
            return;
        }
        
        vis[r][c] = 1;
        
        arr.add(""+(r-baseR)+(c-baseC));
        
        dfs(grid,r-1,c,baseR,baseC,arr,vis);
        dfs(grid,r,c-1,baseR,baseC,arr,vis);
        dfs(grid,r+1,c,baseR,baseC,arr,vis);
        dfs(grid,r,c+1,baseR,baseC,arr,vis);
    }
}
