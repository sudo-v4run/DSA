//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for (int i = 0; i < V; i++)
                list.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if (new Solution().isCyclic(V, list) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends

class Solution {
    
    public boolean isCyclic(int v, ArrayList<ArrayList<Integer>> adj) {
        HashSet<Integer> vis = new HashSet<>();
        int nodeVis[] = new int[v];
        
        for(int i = 0 ; i < v ; i++){
            if(dfs(i,adj,vis,nodeVis)){
                return true;
            }
        }
        
        return false;
    }
    
    public static boolean dfs(int node, ArrayList<ArrayList<Integer>> adj,
                            HashSet<Integer> vis, int[] nodeVis){
        
        if(vis.contains(node)){
            return true;
        }
        
        if(nodeVis[node]==1){
            return false;
        }
        
        vis.add(node);
        nodeVis[node] = 1;
        
        for(int nei : adj.get(node)){
            if(dfs(nei,adj,vis,nodeVis)){
                return true;
            }
        }
        
        vis.remove(node);
        
        return false;
    }
    
    
    
    
    
    
    
    
    // public boolean isCyclic(int v, ArrayList<ArrayList<Integer>> adj) {
    //     HashSet<Integer> vis = new HashSet<>();
        
    //     for(int i = 0 ; i < v ; i++){
    //         if(dfs(i,adj,vis)){
    //             return true;
    //         }
    //     }
        
    //     return false;
    // }
    // public static boolean dfs(int node, ArrayList<ArrayList<Integer>> adj,
    //                         HashSet<Integer> vis){
        
    //     if(vis.contains(node)){
    //         return true;
    //     }
        
    //     vis.add(node);
        
    //     for(int nei : adj.get(node)){
    //         if(dfs(nei,adj,vis)){
    //             return true;
    //         }
    //     }
        
    //     vis.remove(node);
    //     adj.removeAll(adj.get(node));
        
    //     return false;
    // }
}