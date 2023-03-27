//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Gfg
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            // arraylist of arraylist to represent graph
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            int V = Integer.parseInt(sc.next());
            int E = Integer.parseInt(sc.next());
            
            for(int i =0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
                
            for(int i = 1; i <= E; i++)
            {    int u = Integer.parseInt(sc.next());
                 int v = Integer.parseInt(sc.next());
                 
                 // adding directed edgese between 
                 // vertex 'u' and 'v'
                 adj.get(u).add(v);
            }
            
            Solution ob = new Solution();
            System.out.println(ob.kosaraju(V, adj));
		}
    }
}

// } Driver Code Ends

class Solution
{
    public int kosaraju(int v, ArrayList<ArrayList<Integer>> adj)
    {
        // TC -> O(3*(E+V))...
        
        // Step 1... Sorting according to their finishing time...TopoSort...
        
        int vis[] = new int[v];
        Stack<Integer> s = new Stack<>();
        
        for(int i = 0 ; i < v ; i++){
            if(vis[i] != 1){
                dfs(i,adj,vis,s);
            }
        }
        
        // Step 2... Reverse/Transpose the graph...
        
        ArrayList<ArrayList<Integer>> revAdj = new ArrayList<>();
        
        for(int i = 0 ; i < v ; i++){
            vis[i] = 0;
            revAdj.add(new ArrayList<>());
        }
        
        for(int i = 0 ; i < v ; i++){
            for(int nei : adj.get(i)){
                
                revAdj.get(nei).add(i);
            }
        }
        
        // Step 3... Apply DFS on Stack elements with revAdj...
        
        int scc = 0;
        
        while(!s.isEmpty()){
            int pop = s.pop();
            if(vis[pop] != 1){
                scc++;
                dfs2(pop,revAdj,vis);
            }
        }
        
        return scc;
    }
    public static void dfs( int v, ArrayList<ArrayList<Integer>> adj, int vis[], 
                            Stack<Integer> s ){
        
        vis[v] = 1;
        
        for(int nei : adj.get(v)){
            if(vis[nei] != 1){
                dfs(nei,adj,vis,s);
            }
        }
        
        s.push(v);
    }
    public static void dfs2(int v, ArrayList<ArrayList<Integer>> adj, int vis[]){
        
        vis[v] = 1;
        
        for(int nei : adj.get(v)){
            if(vis[nei] != 1){
                dfs2(nei,adj,vis);
            }
        }
    }
}
