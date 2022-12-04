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
    // DFS...
    
    // static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    // {
    //     int vis[] = new int[V];
    //     Stack<Integer> s = new Stack<>();
        
    //     for(int i = 0 ; i < V ; i++){
    //         if(vis[i]!=1){
    //             dfs(i,adj,vis,s);
    //         }
    //     }
        
    //     int res[] = new int[s.size()];
    //     int k = 0;
        
    //     while(!s.isEmpty()){
    //         res[k++] = s.pop();
    //     }
        
    //     return res;
    // }
    // public static void dfs( int node,ArrayList<ArrayList<Integer>> adj,int vis[],
    //                         Stack<Integer> s ){
        
    //     vis[node] = 1;
        
    //     for(int nei : adj.get(node)){
    //         if(vis[nei]!=1){
    //             dfs(nei,adj,vis,s);
    //         }
    //     }
        
    //     s.push(node);
    // }
    
    
    
    
    // BFS... Kahn's Algo...
    
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        Queue<Integer> q = new LinkedList<>();
        
        int inDeg[] = new int[V];
        
        findInDeg(adj,V,inDeg);
        
        for(int i = 0 ; i < V ; i++){
            if(inDeg[i]==0){
                q.offer(i);
            }
        }
        
        int res[] = new int[V];
        int k = 0;
        
        while(!q.isEmpty()){
            int pop = q.poll();
            res[k++] = pop;
            for(int nei : adj.get(pop)){
                inDeg[nei]--;
                if(inDeg[nei]==0){
                    q.add(nei);
                }
            }
        }
        
        return res;
        
    }
    public static void findInDeg(ArrayList<ArrayList<Integer>> adj, int v,int inDeg[]){
        for(int i = 0 ; i < v ; i++){
            for(int nei : adj.get(i)){
                inDeg[nei]++;
            }
        }
    }
}
