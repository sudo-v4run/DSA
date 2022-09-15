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

class Solution {
    int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        
        int[] vis = new int[V];
        int count = 0;
        for (int i = 0; i < V; i++)
        {
            if (vis[i] == 0)
            {
                dfs(i, vis, adj);
                count++;
            }
        }
        return count;
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