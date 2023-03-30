//{ Driver Code Starts
// Initial Template for Java
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>>adj = new ArrayList<>();
            for(int i = 0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
            for(int i = 0; i < E; i++){
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            ArrayList<Integer>ans = obj.articulationPoints(V, adj);
            for (int i =0 ;i < ans.size (); i++) 
                System.out.print (ans.get (i) + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution
{
    static int timer = 0;
    
    public ArrayList<Integer> articulationPoints(int n,ArrayList<ArrayList<Integer>> adj)
    {
        
        int dsc[] = new int[n];
        int low[] = new int[n];
        int vis[] = new int[n];
        
        int APs[] = new int[n];
        
        dfs(0,-1,vis,adj,dsc,low,APs);
        
        ArrayList<Integer> res = new ArrayList<>();
        
        for(int i = 0 ; i < n ; i++){
            if(APs[i] == 1){
                res.add(i);
            }
        }
        
        if(res.size()==0){
            res.add(-1);
            return res;
        }
        
        return res;
    }
    public static void dfs( int v, int parent, int vis[], ArrayList<ArrayList<Integer>> adj,
                            int dsc[], int low[], int APs[]){
        
        vis[v] = 1;
        dsc[v] = low[v] = timer;
        timer++;
        int child = 0;
        
        for(int nei : adj.get(v)){
            if(nei == parent){
                continue;
            }
            if(vis[nei] != 1){
                child++;
                dfs(nei,v,vis,adj,dsc,low,APs);
                low[v] = Math.min(low[v],low[nei]);
                
                // Check for AP...
                
                if(low[nei] >= dsc[v] && parent != -1){
                    APs[v] = 1;
                }
                
            }else{
                low[v] = Math.min(low[v],dsc[nei]);
            }
        }
        
        if(child > 1 && parent == -1){
            APs[v] = 1;
        }
    }
}