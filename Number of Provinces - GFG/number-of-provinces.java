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


//User function Template for Java

class Solution {
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        int vis[] = new int[V];
        int cnt = 0;
          ArrayList<ArrayList<Integer>> adjls=new ArrayList<ArrayList<Integer>>();
      for(int i=0;i<V;i++){
          adjls.add(new ArrayList<Integer>());
      }
       
      for(int i=0;i<V;i++){
          for(int j=0;j<V;j++){
              if(adj.get(i).get(j)==1){
                  adjls.get(i).add(j);
                  adjls.get(j).add(i);
              }
          }
      }
       
        for(int i = 0 ; i < V ; i++){
            if(vis[i]!=1){
                dfs(i,vis,adjls);
                cnt++;
            }
        }
        return cnt;
    }
    static void dfs(int s , int vis[] , ArrayList<ArrayList<Integer>> adj){
        vis[s] = 1;
        for(int nei : adj.get(s)){
            if(vis[nei]!=1){
                dfs(nei,vis,adj);
            }
        }
    }
};