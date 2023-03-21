//{ Driver Code Starts


import java.util.*;
import java.io.*;
import java.lang.*;

public class Main{
	static BufferedReader br;
	static PrintWriter ot;
    public static void main(String args[]) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		ot = new PrintWriter(System.out);
		int t = Integer.parseInt(br.readLine().trim());
		while(t-- > 0){
			String s[] = br.readLine().trim().split(" ");
			int V = Integer.parseInt(s[0]);
			int E = Integer.parseInt(s[1]);
			int edges[][] = new int[E][3];
			for(int i = 0; i < E; i++){
				s = br.readLine().trim().split(" ");
				edges[i][0] = Integer.parseInt(s[0]);
				edges[i][1] = Integer.parseInt(s[1]);
				edges[i][2] = Integer.parseInt(s[2]);
			}
			ot.println(new Solution().spanningTree(V, E, edges));
		}
		ot.close();
	}
}
// } Driver Code Ends

class Solution{
    
    static class Pair{
        
        int node,wt;
        Pair(int node, int wt){
            this.node = node;
            this.wt = wt;
        }
    }
	static int spanningTree(int V, int E, int edges[][]){
	    
	    ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
	    
	    for(int i = 0 ; i < V ; i++){
	        adj.add(new ArrayList<>());
	    }
	    
	    for(int ed[] : edges){
	        
	        int u = ed[0];
	        int v = ed[1];
	        int wt = ed[2];
	        
	        adj.get(u).add(new Pair(v,wt));
	        adj.get(v).add(new Pair(u,wt));
	    }
	    
	    PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->{return a.wt-b.wt;});
	    pq.add(new Pair(0,0));
	    
	    int vis[] = new int[V];
	    int sum = 0;
	    
	    while(!pq.isEmpty()){
	        Pair pop = pq.poll();
	        int node = pop.node;
	        int wt = pop.wt;
	        
	        if(vis[node] == 1){
	            continue;
	        }
	        
	        vis[node] = 1;
	        sum += wt;
	        
	        for(Pair nei : adj.get(node)){
	            if(vis[nei.node] != 1){
	                pq.add(new Pair(nei.node,nei.wt));
	            }
	        }
	        
	    }
	    
	    return sum;
	}
}