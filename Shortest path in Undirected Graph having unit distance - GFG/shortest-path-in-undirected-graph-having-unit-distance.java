//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m=sc.nextInt();
            int[][] edge = new int[m][2];
            for(int i=0;i<m;i++){
                edge[i][0]=sc.nextInt();
                edge[i][1]=sc.nextInt();
            }
            int src=sc.nextInt();
            Solution obj = new Solution();
            int res[] = obj.shortestPath(edge,n,m,src);
            for(int i=0;i<n;i++){
                System.out.print(res[i]+" ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends

class Solution {
    static class Pair{
        int node,wt;
        Pair(int node, int wt){
            this.node = node;
            this.wt = wt;
        }
    }
    public int[] shortestPath(int[][] edges,int n,int m ,int src) {
        int v = n;
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for(int i = 0 ; i < v ; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int ed[] : edges){
            adj.get(ed[0]).add(ed[1]);
            adj.get(ed[1]).add(ed[0]);
        }
        
        int vis[] = new int[v];
        Queue<Pair> q = new LinkedList<>();
        int dis[] = new int[v];
        Arrays.fill(dis,-1);
        
        q.add(new Pair(src,0));
        vis[src] = 1;
        
        while(!q.isEmpty()){
            Pair pop = q.poll();
            
            dis[pop.node] = pop.wt;
            
            for(int nei : adj.get(pop.node)){
                if(vis[nei] != 1){
                    vis[nei] = 1;
                    q.add(new Pair(nei,pop.wt+1));
                }
            }
        }
        
        return dis;
    }
}