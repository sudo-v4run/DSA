//{ Driver Code Starts
// Initial Template for Java
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
            ArrayList<ArrayList<Integer>> adj =
                new ArrayList<ArrayList<Integer>>();
            for (int i = 0; i < V; i++) adj.add(new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            ArrayList<Integer> ans = obj.dfsOfGraph(V, adj);
            for (int i = 0; i < ans.size(); i++)
                System.out.print(ans.get(i) + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution {
    
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        
        int vis[] = new int[V];
        
        //return dfs(0,vis,adj);
        
     //.......  Using Stack    ............................................................
        
        ArrayList<Integer> res = new ArrayList<>();
        Stack<Integer> st = new Stack<>();
        
        st.push(0);
        //vis[0] = 1;
       // res.add(0);
        
        while(!st.isEmpty()){
            int cur = st.pop();
            
            
            // if(vis[cur]!=1){
            //     res.add(cur);
            //     vis[cur] = 1;
            // }
            
            for(int nei = adj.get(cur).size()-1 ; nei>=0 ; nei--){
                if(vis[adj.get(cur).get(nei)]!=1){
                    st.push(adj.get(cur).get(nei));
                }
            }
            if(vis[cur]!=1)
                res.add(cur);
            vis[cur] = 1;
        }
        
        return res;

    }
    
    ArrayList<Integer> res = new ArrayList<>();
    
    public ArrayList<Integer> dfs(int s,int[] vis,ArrayList<ArrayList<Integer>> adj){
        vis[s] = 1;
        res.add(s);
        for(int nei : adj.get(s)){
            if(vis[nei]!=1){
                dfs(nei,vis,adj);
            }
        }
        
        return res;
    }
}