//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isCycle(V, adj);
            if (ans)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends

class Solution {
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        
        
        // Same with BFS also...if adj node is already visited 
        //                              and it's not the parent,return true...
        // In BFS, you can maintain a Pair of node and it's parent....
        // push all neighbouring nodes of the cur node and mark them visit...
        // But before that if any neighbouring node is already visited and it's
        //  node the parent node, return true coz it means that this node is
        // visisted by some other node as the parent which forms a closed figure,
        // i.e cycle exists...
        
        int vis[] = new int[V];
        
        for(int i = 0 ; i < V ; i++){
            if(vis[i] != 1){
                if(dfs(i,adj,vis,-1)){
                    return true;
                }
            }
        }
        
        return false;
    }
    public static boolean dfs(int v, ArrayList<ArrayList<Integer>> adj, int vis[], int parent){
        vis[v] = 1;
        
        for(int nei : adj.get(v)){
            if(vis[nei] == 1 && nei != parent){
                return true;
            }
            
            if(vis[nei] != 1){
                if(dfs(nei,adj,vis,v)){
                    return true;
                }
            }
        }
        
        return false;
    }
}