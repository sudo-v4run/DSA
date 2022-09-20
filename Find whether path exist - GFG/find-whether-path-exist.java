//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int[][] grid = new int[n][n];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < n; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            boolean ans = obj.is_Possible(grid);
            if(ans)
                System.out.println("1");
            else 
                System.out.println("0");
        }
    }
}
// } Driver Code Ends



class Solution
{
    static class Pair{
        int r,c;
        Pair(int r,int c){
            this.r = r;
            this.c = c;
        }
    }
    
    
    public boolean is_Possible(int[][] grid)
    {
        Queue<Pair> q = new LinkedList<>();
        int vis[][] = new int[grid.length][grid[0].length];
        for(int i = 0 ; i < grid.length ; i++){
            for(int j = 0 ; j < grid[0].length ; j++){
                if(grid[i][j]==1){
                    q.offer(new Pair(i,j));
                    break;
                }
            }
        }
        
        while(!q.isEmpty()){
            Pair s = q.poll();
            int x = s.r;
            int y = s.c;
            
            if(x<0||x>=grid.length||y<0||y>=grid[0].length)
                continue;
            
            if(grid[x][y]==0)
                continue;
                
            if(vis[x][y]==1)
                continue;
            
            if(grid[x][y]==2){
                return true;
            }
            
            vis[x][y] = 1;
            
            q.offer(new Pair(x-1,y));
            q.offer(new Pair(x,y-1));
            q.offer(new Pair(x+1,y));
            q.offer(new Pair(x,y+1));
        }       
        
        return false;
    }
}