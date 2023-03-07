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
        
        // BFS will not work for detecting cycles in directed graphs...
        // 0 -> 1 ; 0 -> 2 ; 1 -> 2 : Test Case eg where BFS fails 
        
        HashSet<Integer> hs = new HashSet<>();
        int vis[] = new int[v];
        
        for(int i = 0 ; i < v ; i++){
            if(vis[i] != 1){
                if(dfs(i,adj,vis,hs)){
                    return true;
                }
            }
        }
        
        return false;
    }
    public static boolean dfs( int v, ArrayList<ArrayList<Integer>> adj, int vis[],
                               HashSet<Integer> hs ){
        hs.add(v);
        vis[v] = 1;
        
        for(int nei : adj.get(v)){
            if(hs.contains(nei)){
                return true;
            }else if(vis[nei] != 1){
                if(dfs(nei,adj,vis,hs)){
                    return true;
                }
            }
        }
        
        hs.remove(v);
        
        return false;
    }
}