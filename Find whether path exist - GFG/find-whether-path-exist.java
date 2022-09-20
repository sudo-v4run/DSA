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
        int vis[][] = new int[grid.length][grid[0].length];
        for(int i = 0 ; i < grid.length ; i++){
            for(int j = 0 ; j < grid[0].length ; j++){
                if(grid[i][j]==1){
                    if(bfs(new Pair(i,j),grid,vis)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public static boolean bfs(Pair src, int arr[][],int vis[][]){
        Queue<Pair> q = new LinkedList<>();
        q.offer(src);
        
        while(!q.isEmpty()){
            Pair s = q.poll();
            int x = s.r;
            int y = s.c;
            
            if(x<0||x>=arr.length||y<0||y>=arr[0].length)
                continue;
            
            if(arr[x][y]==0)
                continue;
                
            if(vis[x][y]==1)
                continue;
            
            if(arr[x][y]==2){
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