//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T-- > 0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[][] edge = new int[m][3];
			for (int i = 0; i < m; i++) {
				edge[i][0] = sc.nextInt();
				edge[i][1] = sc.nextInt();
				edge[i][2] = sc.nextInt();
			}
			Solution obj = new Solution();
			int res[] = obj.shortestPath(n, m,edge);
			for (int i = 0; i < n; i++) {
				System.out.print(res[i] + " ");
			}
			System.out.println();
		}
	}
}
// } Driver Code Ends

class Solution {
    
    static class Pair{
        int node;
        int wt;
        
        Pair(int node, int wt){
            this.node = node;
            this.wt = wt;
        }
    }

	public int[] shortestPath(int n,int e, int[][] edges) {
	    
	    ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
	    
	    for(int i = 0 ; i < n ; i++){
	        adj.add(new ArrayList<>());
	    }
	    
	    for(int ed[] : edges){
	        int u = ed[0];
	        int v = ed[1];
	        int wt = ed[2];
	        
	        adj.get(u).add(new Pair(v,wt));
	    }
	    
	    int vis[] = new int[n];
        Stack<Integer> s = new Stack<>();
        
        for(int i = 0 ; i < n ; i++){
            if(vis[i] != 1){
                dfs(i,adj,vis,s);
            }
        }
        
        int dis[] = new int[n];
        
        Arrays.fill(dis,(int)1e7);
        
        dis[0] = 0;
        
        while(!s.isEmpty()){
            int cur = s.pop();
            
            for(Pair nei : adj.get(cur)){
                int dist = dis[cur] + nei.wt;
                dis[nei.node] = Math.min(dis[nei.node],dist);
            }
        }
        
        for(int i=0; i<n; i++){
		    if(dis[i] == (int)1e7)
		        dis[i] = -1;
		}
        
        return dis;
	}
	public static void dfs(int v,ArrayList<ArrayList<Pair>> adj,int vis[],Stack<Integer> s){
        
        vis[v] = 1;
        
        for(Pair nei : adj.get(v)){
            if(vis[nei.node] != 1){
                dfs(nei.node,adj,vis,s);
            }
        }
        
        s.add(v);
    }
}