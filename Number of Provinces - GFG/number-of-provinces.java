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
        
        int[] visited = new int[V];
        int count = 0;
        for (int i = 0; i < V; i++)
        {
            if (visited[i] == 0)
            {
                dfs(adj, visited, i);
                count++;
            }
        }
        return count;
    }
       
    void dfs(ArrayList<ArrayList<Integer>> M, int[] visited, int i)
    {
        for (int j = 0; j < M.size(); j++)
        {
            if (i!=j && M.get(i).get(j) == 1 && visited[j] == 0)
            {
                visited[j] = 1;
                dfs(M, visited, j);
            }
        }
    }
};