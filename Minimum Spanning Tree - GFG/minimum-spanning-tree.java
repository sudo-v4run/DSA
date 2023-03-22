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
    
    // Prim's Algo...
    
        // Only to find Sum... To find MST edges also..check the below code...
    
//     static class Pair{
        
//         int node,wt;
//         Pair(int node, int wt){
//             this.node = node;
//             this.wt = wt;
//         }
//     }
// 	static int spanningTree(int V, int E, int edges[][]){
	    
// 	    ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
	    
// 	    for(int i = 0 ; i < V ; i++){
// 	        adj.add(new ArrayList<>());
// 	    }
	    
// 	    for(int ed[] : edges){
	        
// 	        int u = ed[0];
// 	        int v = ed[1];
// 	        int wt = ed[2];
	        
// 	        adj.get(u).add(new Pair(v,wt));
// 	        adj.get(v).add(new Pair(u,wt));
// 	    }
	    
// 	    PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->{return a.wt-b.wt;});
// 	    pq.add(new Pair(0,0));
	    
// 	    int vis[] = new int[V];
// 	    int sum = 0;
	    
// 	    while(!pq.isEmpty()){
// 	        Pair pop = pq.poll();
// 	        int node = pop.node;
// 	        int wt = pop.wt;
	        
// 	        if(vis[node] == 1){
// 	            continue;
// 	        }
	        
// 	        vis[node] = 1;
// 	        sum += wt;
	        
// 	        for(Pair nei : adj.get(node)){
// 	            if(vis[nei.node] != 1){
// 	                pq.add(new Pair(nei.node,nei.wt));
// 	            }
// 	        }
	        
// 	    }
	    
// 	    return sum;
// 	}
	
	
	
	
	    // Finding MST edges also...
	
//     static class Tuple{
//         int node,wt,parent;
//         Tuple(int node, int wt, int parent){
//             this.node = node;
//             this.wt = wt;
//             this.parent = parent;
//         }
//     }
//     static class Pair{
        
//         int first,second;
//         Pair(int first, int second){
//             this.first = first;
//             this.second = second;
//         }
//     }
// 	static int spanningTree(int V, int E, int edges[][]){
	    
// 	    ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
	    
// 	    for(int i = 0 ; i < V ; i++){
// 	        adj.add(new ArrayList<>());
// 	    }
	    
// 	    for(int ed[] : edges){
	        
// 	        int u = ed[0];
// 	        int v = ed[1];
// 	        int wt = ed[2];
	        
// 	        adj.get(u).add(new Pair(v,wt));
// 	        adj.get(v).add(new Pair(u,wt));
// 	    }
	    
// 	    PriorityQueue<Tuple> pq = new PriorityQueue<>((a,b)->{return a.wt-b.wt;});
// 	    pq.add(new Tuple(0,0,-1));
	    
// 	    int vis[] = new int[V];
// 	    int sum = 0;
	    
// 	    ArrayList<Pair> mst = new ArrayList<>();
	    
// 	    while(!pq.isEmpty()){
// 	        Tuple pop = pq.poll();
// 	        int node = pop.node;
// 	        int wt = pop.wt;
// 	        int parent = pop.parent;
	        
// 	        if(vis[node] == 1){
// 	            continue;
// 	        }
	        
// 	        if(parent != -1)
// 	            mst.add(new Pair(node,parent));
	            
// 	        vis[node] = 1;   
// 	        sum += wt;
	        
// 	        for(Pair nei : adj.get(node)){
// 	            if(vis[nei.first] != 1){
// 	                pq.add(new Tuple(nei.first,nei.second,node));
// 	            }
// 	        }
	        
// 	    }
	    
// 	    for(Pair ed : mst){
// 	        System.out.println(ed.first+" "+ed.second);
// 	    }
	    
// 	    return sum;
// 	}


    // Kruskal's...
    
    
    static class DisjointSet{
        int[] parent,rank;
        
        DisjointSet(int n){
            parent = new int[n];
            for(int i = 0 ; i < n ; i++){
                parent[i] = i;
            }
            
            rank = new int[n];
            Arrays.fill(rank,1);
        }
        
        int findParent(int u){
            if(parent[u] == u){
                return u;
            }
            
            return parent[u] = findParent(parent[u]);
        }
        
        void union(int a, int b){
            int parent_a = findParent(a);
            int parent_b = findParent(b);
            
            if(parent_a == parent_b){
                return;
            }
            
            int rank_parent_a = rank[parent_a];
            int rank_parent_b = rank[parent_b];
            
            if(rank_parent_a < rank_parent_b){
                parent[parent_a] = parent[b];
            }else if(rank_parent_a > rank_parent_b){
                parent[parent_b] = parent[a];
            }else{
                parent[parent_b] = parent[a];
                rank[parent_a]++;
            }
        }
    }
	static int spanningTree(int V, int E, int edges[][]){
	    
	    Arrays.sort(edges,(a,b)->{return a[2]-b[2];});
	    
	    DisjointSet d = new DisjointSet(V);
	    int sum = 0;
	    
	    for(int ed[] : edges){
	        int u = ed[0];
	        int v = ed[1];
	        int wt = ed[2];
	        
	        if(d.findParent(u) != d.findParent(v)){
	            sum += wt;
	            d.union(u,v);
	        }
	    }
	    
	    return sum;
	}
    
    
    
    
}