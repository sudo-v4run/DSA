//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            String st[] = read.readLine().trim().split("\\s+");
            int edg = Integer.parseInt(st[0]);
            int nov = Integer.parseInt(st[1]);

            for (int i = 0; i < nov + 1; i++)
                list.add(i, new ArrayList<Integer>());

            int p = 0;
            for (int i = 1; i <= edg; i++) {
                String s[] = read.readLine().trim().split("\\s+");
                int u = Integer.parseInt(s[0]);
                int v = Integer.parseInt(s[1]);
                list.get(u).add(v);
            }

            int[] res = new Solution().topoSort(nov, list);

            if (check(list, nov, res) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
    static boolean check(ArrayList<ArrayList<Integer>> list, int V, int[] res) {
        
        if(V!=res.length)
        return false;
        
        int[] map = new int[V];
        for (int i = 0; i < V; i++) {
            map[res[i]] = i;
        }
        for (int i = 0; i < V; i++) {
            for (int v : list.get(i)) {
                if (map[i] > map[v]) return false;
            }
        }
        return true;
    }
}

// } Driver Code Ends

class Solution
{
    static int[] topoSort(int v, ArrayList<ArrayList<Integer>> adj) 
    {
        
        int vis[] = new int[v];
        ArrayList<Integer> res = new ArrayList<>();
        
        for(int i = 0 ; i < v ; i++){
            if(vis[i] != 1){
                dfs(i,adj,vis,res);
            }
        }
        
        int ans[] = new int[v];
        int k = 0;
        
        for(int i = res.size()-1 ; i >=0 ; i--){
            ans[k++] = res.get(i);
        }
        
        return ans;
        
        // Kahn's Algo - BFS...
        
        // int indeg[] = new int[v];
        // findInDeg(adj,indeg);
    }
    public static void findInDeg(ArrayList<ArrayList<Integer>> adj, int indeg[]){
        
        for(ArrayList<Integer> neis : adj){
            for(int nei : neis){
                indeg[nei]++;
            }
        }
    }
    public static void dfs( int v, ArrayList<ArrayList<Integer>> adj, int vis[], 
                            ArrayList<Integer> res ){
    
        vis[v] = 1;
        
        for(int nei : adj.get(v)){
            if(vis[nei] != 1){
                dfs(nei,adj,vis,res);
            }
        }
        
        res.add(v);
    }
}
