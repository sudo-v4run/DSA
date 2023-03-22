//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int V = Integer.parseInt(read.readLine());
            
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            for(int i=0; i<V; i++)
            {
                String S[] = read.readLine().split(" ");
                ArrayList<Integer> temp = new ArrayList<>();
                for(int j=0; j<V; j++)
                    temp.add(Integer.parseInt(S[j]));
                adj.add(temp);
            }

            Solution ob = new Solution();
            System.out.println(ob.numProvinces(adj,V));
        }
    }
}
// } Driver Code Ends

class DisjointSet{
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


class Solution {
    int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        
        // int[] vis = new int[V];
        // int count = 0;
        // for (int i = 0; i < V; i++)
        // {
        //     if (vis[i] == 0)
        //     {
        //         dfs(i, vis, adj);
        //         count++;
        //     }
        // }
        // return count;
        
        
        // using DisjointSet...
        
        DisjointSet ds = new DisjointSet(V);
        
        for(int i = 0 ; i < V ; i++){
            for(int j = 0 ; j < V ; j++){
                if(adj.get(i).get(j) == 1){
                    ds.union(i,j);
                }
            }
        }
        
        int cnt = 0;
        for(int i = 0 ; i < V ; i++){
            if(ds.parent[i] == i){
                cnt++;
            }
        }
        
        return cnt;
    }
       
    void dfs(int s , int vis[] , ArrayList<ArrayList<Integer>> adj)
    {
        for (int nei = 0; nei < adj.size(); nei++)
        {
            if (adj.get(s).get(nei) != 0 && vis[nei] != 1)
            {
                vis[nei] = 1;
                dfs(nei, vis, adj);
            }
        }
    }
};